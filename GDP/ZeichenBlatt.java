
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ZeichenBlatt {
    private List<Figur> figuren = new ArrayList<Figur>();
    private Color linienFarbe = Color.BLACK;
    private Color fuellFarbe = Color.RED;


    /**
     * zeichnet das Zeichenblatt
     */
    public void zeichnen(SEGraphics seg) {
        for (Figur figur : figuren) {
            figur.zeichnen(seg);
        }
    }

    /**
     * fügt eine Figur zum Zeichenblatt hinzu
     */
    public void addFigur(Figur f) {
        f.setFuellFarbe(fuellFarbe);
        f.setLinienFarbe(linienFarbe);
        figuren.add(f);
    }

    /**
     * Gibt die Figur zurueck, welche am naechten an einem Punkt liegt
     */
    public Figur figurBeiPunkt(Vec2 punkt) {
        Figur naechste = null;
        double besterWert = Double.POSITIVE_INFINITY;
        for (int i = figuren.size() - 1; i >= 0; i--) {
            Figur figur = figuren.get(i);
            double abstand = figur.abstandZu(punkt);
            if (abstand < besterWert) {
                besterWert = abstand;
                naechste = figur;
            }
        }
        return naechste;
    }

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
