import java.awt.*;


public abstract class Figur {
    private Color linienFarbe = Color.BLACK;
    private Color fuellFarbe = Color.RED;

    /**
     * zeichnet die Figur mit dem gegebenen SEGraphics Objekt
     */
    public void zeichnen(SEGraphics seg) {
        seg.setStrokeColor(linienFarbe);
        seg.setFillColor(fuellFarbe);
    }

    /**
     * Liefert den Abstand vom Punkt p zur Figur.
     * Wenn der Punkt im inneren der Figur liegt, ist das Ergebnis 0
     */
    public abstract double abstandZu(Vec2 p);

    /**
     * verschiebt die Figur um delta.x Einheiten nach rechts und delta.y Einheiten nach unten.
     */
    public abstract void verschiebenUm(Vec2 delta);

    public Color getLinienFarbe() {
        return linienFarbe;
    }

    public void setLinienFarbe(Color linienFarbe) {
        this.linienFarbe = linienFarbe;
    }

    public Color getFuellFarbe() {
        return fuellFarbe;
    }

    public void setFuellFarbe(Color fuellFarbe) {
        this.fuellFarbe = fuellFarbe;
    }

}
