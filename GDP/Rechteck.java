

public class Rechteck extends Figur{
	private Vec2 start;
	private double hoehe;
	private double breite;
	private Vec2 ende;
	
	
	public Rechteck(Vec2 start, Vec2 ende) {
		this.start=start;
		this.ende=ende;
		this.hoehe = ende.y-start.y;
		this.breite = ende.x-start.x;

	}
	
	@Override
	public void zeichnen(SEGraphics seg) {
		super.zeichnen(seg);
		double savex;
		double savey;
		if(start.x < ende.x) {
			savex = start.x;
		} else {
			savex = ende.x;
		}
		if(start.y < ende.y) {
			savey = start.y;
		} else {
			savey = ende.y;
		}
		seg.drawRect(savex, savey, breite, hoehe);
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
		ende = pos;
		if(start.y < ende.y) {
			hoehe = ende.y-start.y;
		} else {
			hoehe = start.y-ende.y;
		}
		if(start.x < ende.x) {
			breite = ende.x-start.x;
		} else {
			breite = start.x-ende.x;
		}
		
	}

}
