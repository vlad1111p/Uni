import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


public class Gui extends JFrame {
    private static final long serialVersionUID = 1L;

    private DrawArea drawArea;
    private boolean antiAliasing = true; // aktivieren für schönere, langsamere Grafiken
    private ZeichenBlatt zeichenBlatt;
    private JToggleButton currentToolBtn;
    private ZeichenTool activeTool;
    private boolean mouse1Down = false;

    public Gui(List<ZeichenTool> tools, ZeichenBlatt zeichenBlatt) {
        super("Grafik-Editor");
        this.zeichenBlatt = zeichenBlatt;

        Container contentPane = getContentPane();


        initColorChooser(contentPane);
        initToolbox(tools, contentPane);
        initDrawArea(contentPane);


        setPreferredSize(new Dimension(800, 600));
        pack();
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initColorChooser(Container contentPane) {
        Container colorBox = new Container();
        colorBox.setLayout(new WrapLayout(FlowLayout.LEFT));

        final Canvas showCurrentColor = new Canvas() {
            private static final long serialVersionUID = -3017027010646925356L;

            @Override
            public void paint(Graphics g) {
                g.setColor(zeichenBlatt.getFuellFarbe());
                g.fillRect(7, 7, getWidth() - 7, getHeight() - 7);
                g.setColor(zeichenBlatt.getLinienFarbe());
                g.fillRect(0, 0, getWidth() - 7, getHeight() - 7);
            }
        };
        showCurrentColor.setBackground(colorBox.getBackground());
        showCurrentColor.setPreferredSize(new Dimension(25, 25));
        colorBox.add(showCurrentColor);

        int colors[] = {
                0x000000,
                0xffffff,
                0xff0000,
                0x00ff00,
                0x0000ff,
                0xffff00,
                0xff00ff,
                0x00ffff,
        };
        for (int c : colors) {
            final Color color = new Color(c);
            Canvas cbtn = new Canvas();
            cbtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        zeichenBlatt.setLinienFarbe(color);
                    } else if (e.getButton() == MouseEvent.BUTTON3) {
                        zeichenBlatt.setFuellFarbe(color);
                    }
                    showCurrentColor.repaint();
                }
            });
            cbtn.setBackground(color);
            cbtn.setForeground(color);
            cbtn.setPreferredSize(new Dimension(25, 25));
            colorBox.add(cbtn);
        }
        colorBox.setPreferredSize(new Dimension(35, 100));
        contentPane.add(colorBox, BorderLayout.LINE_START);
    }

    private void initDrawArea(Container contentPane) {
        drawArea = new DrawArea();
        contentPane.add(drawArea, BorderLayout.CENTER);

        drawArea.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    mouse1Down = false;
                    activeTool.ende(new Vec2(e.getX(), e.getY()));
                    drawArea.repaint();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    mouse1Down = true;
                    activeTool.start(new Vec2(e.getX(), e.getY()));
                    drawArea.repaint();
                }

            }

        });

        drawArea.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {
                if (mouse1Down) {
                    activeTool.ziehen(new Vec2(e.getX(), e.getY()));
                    drawArea.repaint();
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (mouse1Down) {
                    activeTool.ziehen(new Vec2(e.getX(), e.getY()));
                    drawArea.repaint();
                }
            }
        });
    }

    private void initToolbox(List<ZeichenTool> tools, Container contentPane) {
        Container toolBox = new Container();
        toolBox.setLayout(new WrapLayout(FlowLayout.LEFT));
        for (final ZeichenTool tool : tools) {
            final JToggleButton btn = new JToggleButton(tool.getName());
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    changeActiveTool(btn, tool);
                }
            });
            if (tool == tools.get(0)) {
                changeActiveTool(btn, tool);
            }
            toolBox.add(btn);
        }
        contentPane.add(toolBox, BorderLayout.NORTH);
    }

    private void changeActiveTool(JToggleButton btn, ZeichenTool tool) {
        if (currentToolBtn != null) {
            currentToolBtn.setSelected(false);
        }
        btn.setSelected(true);
        currentToolBtn = btn;
        activeTool = tool;
        activeTool.init(zeichenBlatt);
    }

    public static void create(final List<ZeichenTool> tools, final ZeichenBlatt zeichenBlatt) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception e) {
                        // ignore
                    }

                    new Gui(tools, zeichenBlatt);
                }
            });
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    class DrawArea extends Canvas {
        private static final long serialVersionUID = 6411839952303771403L;


        @Override
        public void paint(Graphics g) {
            BufferStrategy strategy = bufferStrategy();
            SEGraphics seg = graphics(strategy);
            seg.reset();
            zeichenBlatt.zeichnen(seg);
            strategy.show();
            Toolkit.getDefaultToolkit().sync();
        }

        @Override
        public void update(Graphics g) {
            paint(g);
        }

        private SEGraphics graphics(BufferStrategy strategy) {

            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            if (antiAliasing) {
                Graphics2D g2 = (Graphics2D) g;
                RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHints(rh);
            }

            SEGraphics seg = new SEGraphics(g, getWidth(), getHeight());
            return seg;
        }


        private BufferStrategy bufferStrategy() {
            BufferStrategy s = getBufferStrategy();
            if (s == null) {
                createBufferStrategy(2);
                s = getBufferStrategy();
            }
            return s;
        }
    }

}
