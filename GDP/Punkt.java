


public class Punkt {
	double x,y;
	
	public Punkt(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punkt plus(Punkt a) {
		return new Punkt(x + a.x, y + a.y);
	}
	
	public Punkt minus(Punkt a) {
		return new Punkt(x - a.x, y - a.y);
	}
	
	public double dotProduct(Punkt a) {
		return x*a.x + y*a.y;
	}
	
	public void normalize() {
		double len = len();
		if (len > 0) {
			x /= len;
			y /= len;
		}
	}
	
	public double len() {
		return Math.sqrt(x*x + y*y);
	}

	public double distanceTo(Punkt a) {
		return a.minus(this).len();
	}

	public double distanceToLine(Punkt start, Punkt ende) {
		Punkt direction = ende.minus(start);
		direction.normalize();
		Punkt delta = this.minus(start);
		double closest = delta.dotProduct(direction);
		if (closest < 0) {
			return  distanceTo(start);
		} else if (closest > start.distanceTo(ende)) {
			return distanceTo(ende);
		} else {
			return Math.sqrt(delta.len()*delta.len() - closest*closest);
		}
	}

	public void add(Punkt delta) {
		x += delta.x;
		y += delta.y;
	}
	
}
