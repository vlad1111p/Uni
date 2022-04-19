import java.awt.Color;

public class Ball {
	Vec2 position;
	Vec2 geschwindigkeit;
	Color farbe;
	double radius;
	
	public Ball(Vec2 position, Vec2 geschwindigkeit,
				Color farbe, double radius) {
		this.position = position;
		this.geschwindigkeit = geschwindigkeit;
		this.farbe = farbe;
		this.radius = radius;
	}
	
	public void setGeschwindigkeit(Vec2 geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}
	
	public void setPosition(Vec2 position) {
		this.position = position;
	}
	
}
