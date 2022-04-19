

public class Linie extends Figur {
    private Vec2 start;
    private Vec2 ende;

    public Linie(Vec2 start, Vec2 ende) {
        this.start = start;
        this.ende = ende;
    }

    @Override
    public void zeichnen(SEGraphics seg) {
        super.zeichnen(seg);
        seg.drawLine(start.x, start.y, ende.x, ende.y);

    }

    @Override
    public double abstandZu(Vec2 p) {
        return p.distanceToLine(start, ende);
    }


    @Override
    public void verschiebenUm(Vec2 delta) {
        start = start.plus(delta);
        ende = ende.plus(delta);
    }


    public void setEnde(Vec2 ende) {
        this.ende = ende;
    }

}
