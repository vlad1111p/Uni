public class Vec2 {
	public final double x;
	public final double y;
	
	public Vec2(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double length() {
		double length=Math.sqrt((x*x)+(y*y));
		return length;
	}
	
	public Vec2 mult(double factor) {
		Vec2 vec=new Vec2(this.x*factor, this.y*factor);
		return vec;		
	}
	
	public Vec2 plus(Vec2 v) {
		Vec2 vec=new Vec2(this.x+v.x, this.y+v.y);
		return vec;
	}
	
	public Vec2 minus(Vec2 v) {
		Vec2 vec=new Vec2(this.x-v.x, this.y-v.y);
		return vec;
	}
	
	public double skalarProdukt (Vec2 v) {
		double sp=(this.x*v.x)+(this.y*v.y);
		return sp;
	}
	
	public double distanceTo(Vec2 v) {
		double dist= Math.sqrt((this.x-v.x)*(this.x-v.x)+(this.y-v.y)*(this.y-v.y));
		return dist;
	}
	
	public Vec2 normalized(double newLength) {
		Vec2 vec=new Vec2(this.x, this.y);
		if (vec.length()!=0) {
			double newx = 0;
			double newy = 0;
			double ratio=newLength/vec.length();
			newx=vec.x*ratio;
			newy=vec.y*ratio;
			vec = new Vec2(newx, newy);		
		}
		return vec;
	}

}
