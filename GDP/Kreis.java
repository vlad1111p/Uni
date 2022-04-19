public class Kreis extends Figur {
	private Vec2 start;
	private double radius;
	private Vec2 ende;
	
	public Kreis(Vec2 start, Vec2 ende) {
		radius = ende.distanceTo(start);
		this.start=start;
		this.ende=ende;
	}
	
	@Override
	public void zeichnen(SEGraphics seg) {
		super.zeichnen(seg);
		seg.drawCircle(start.x, start.y, radius);
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
	
	public void setEnde(Vec2 pos) {
		this.ende = pos;
		radius = ende.distanceTo(start);
		
	}

}
