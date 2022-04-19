import java.awt.*;

public class SEGraphics {

    private Graphics2D g;
    private final int drawMinX;
    private final int drawMinY;

    private final int drawMaxX;
    private final int drawMaxY;

    public SEGraphics(int drawMinX, int drawMinY, int drawMaxX, int drawMaxY) {
        this.drawMinX = drawMinX;
        this.drawMinY = drawMinY;
        this.drawMaxX = drawMaxX;
        this.drawMaxY = drawMaxY;
    }

    private int normalizeX(double x) {
        return (int) (this.drawMinX + x);
    }

    private int normalizeY(double y) {
        return (int) (this.drawMinY + y);
    }

    public void update(Graphics2D g) {
        this.g = g;
    }

    /**
     * fuellt das Bild mit der gegebenen Farbe
     */
    public void reset(Color color) {
        g.setColor(color);
        g.fillRect(drawMinX, drawMinY, drawMaxX, drawMaxY);
    }

    /**
     * zeichnet einen Kreis mit Angabe von Mittelpunkt (x,y), Radius und Fuellfarbe
     */
    public void drawCircle(double x, double y, double radius, Color c) {
        g.setColor(c);
        g.fillOval((int) (normalizeX(x) - radius), (int) (normalizeY(y) - radius), (int) (2 * radius), (int) (2 * radius));
    }

    /**
     * zeichnet den gegeben Text
     */
    public void drawString(String str, int x, int y, Color c) {
        g.setColor(c);
        g.drawString(str, normalizeX(x), normalizeY(y));
    }

    /**
     * zeichnet eine Linie von (x1,y1) zu (x2,y2)
     */
    public void drawLine(double x1, double y1, double x2, double y2, Color c, float width) {
        g.setColor(c);
        g.setStroke(new BasicStroke(width));
        g.drawLine(normalizeX(x1), normalizeY(y1), normalizeX(x2), normalizeY(y2));
    }
}