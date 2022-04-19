import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

public class Gui extends JFrame implements ActionListener {
    private static final int TIME_STEP_MS = 10;
    private static final long serialVersionUID = 8320867273092453750L;

    private final DrawArea drawArea;
    private Spielfeld spielFeld;

    private long lastTime = System.currentTimeMillis();
    public boolean antiAliasing = true;
    private int tooSlowCount = 0;

    private Gui(Spielfeld spielfeld) {
        super("SE1-Carambolage");
        this.spielFeld = spielfeld;

        this.getContentPane().setPreferredSize(new Dimension(spielfeld.getBreite(), spielfeld.getHoehe()));
        // We need to setResizable to false and call pack to get the correct insets.
        setResizable(false);
        pack();

        final Insets insets = this.getInsets();
        final int drawMaxX = this.getWidth() - insets.right - 1;
        final int drawMaxY = this.getHeight() - insets.bottom - 1;

        drawArea = new DrawArea(insets.left, insets.top, drawMaxX, drawMaxY);
        add(drawArea);
        setVisible(true);

        Timer timer = new Timer(TIME_STEP_MS, this);
        timer.start();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    spielFeld.mouseClicked(e.getX(), e.getY());
                }
            }
        });

    }


    public static void create(final Spielfeld spielfeld) {
        try {
            SwingUtilities.invokeAndWait(() -> new Gui(spielfeld));
        } catch (InvocationTargetException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        long newTime = System.currentTimeMillis();
        double dt = (newTime - lastTime);
        if (dt > 3 * TIME_STEP_MS) {
            dt = 3 * TIME_STEP_MS;
            tooSlowCount++;
            if (tooSlowCount > 10) {
                antiAliasing = false;
            }
        } else {
            tooSlowCount = 0;
        }

        spielFeld.simulationsSchritt(dt / 1000.0);
        drawArea.render();
        lastTime = newTime;
    }

    class DrawArea extends JPanel {
        private static final long serialVersionUID = 6411839952303771403L;
        private SEGraphics seg;

        public DrawArea(int drawMinX, int drawMinY, int drawMaxX, int drawMaxY) {
            seg = new SEGraphics(drawMinX, drawMinY, drawMaxX, drawMaxY);
        }

        public void render() {
            BufferStrategy bs = bufferStrategy();
            do {
                do {
                    Graphics2D g2 = null;
                    try {
                        g2 = (Graphics2D) bs.getDrawGraphics();
                        spielFeld.zeichnen(graphics(g2));
                        Toolkit.getDefaultToolkit().sync();
                    } finally {
                        if (g2 != null) {
                            g2.dispose();
                        }
                    }
                } while (bs.contentsRestored());
                bs.show();
            } while (bs.contentsLost());
        }

        private SEGraphics graphics(Graphics2D g2) {
            if (antiAliasing) {
                RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHints(rh);
            }

            seg.update(g2);
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