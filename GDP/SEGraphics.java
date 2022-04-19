

import java.awt.*;

public class SEGraphics {

    private Graphics2D g;
    private int breite;
    private int hoehe;
    private Color strokeColor = Color.BLACK;
    private Color fillColor = Color.RED;

    public SEGraphics(Graphics2D g, int breite, int hoehe) {
        this.g = g;
        this.breite = breite;
        this.hoehe = hoehe;
    }

    /**
     * setzt das Bild auf weißen Hintergrund zurück
     */
    public void reset() {
        getG().setColor(Color.WHITE);
        getG().fillRect(0, 0, breite, hoehe);
    }

    /**
     * zeichnet einen Kreis mit Angabe von Mittelpunkt (x,y), Radius und Füllfarbe
     */
    public void drawCircle(double x, double y, double radius) {
        getG().setColor(fillColor);
        getG().fillOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
        getG().setColor(strokeColor);
        getG().drawOval((int) (x - radius), (int) (y - radius), (int) (2 * radius), (int) (2 * radius));
    }

    /**
     * zeichnet den gegeben Text
     */
    public void drawString(String str, double x, double y) {
        getG().setColor(strokeColor);
        getG().drawString(str, (int) x, (int) y);
    }

    /**
     * zeichnet eine Linie von (x1,y1) zu (x2,y2)
     */
    public void drawLine(double x1, double y1, double x2, double y2) {
        getG().setColor(strokeColor);
        getG().drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    public void drawRect(double x, double y, double width, double height) {
        getG().setColor(fillColor);
        getG().fillRect((int) x, (int) y, (int) width, (int) height);
        getG().setColor(strokeColor);
        getG().drawRect((int) x, (int) y, (int) width, (int) height);
    }

    public void setStrokeColor(Color color) {
        strokeColor = color;
    }

    public void setFillColor(Color color) {
        fillColor = color;
    }

    public void setStrokeWidth(float width) {
        g.setStroke(new BasicStroke(width));
    }

    public Graphics2D getG() {
        return g;
    }


}
