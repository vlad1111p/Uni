interface Figur {
	double getFlaeche();
}

class Rechteck implements Figur {
	private final double x;
	private final double y;
	private final double width;
	private final double height;

	Rechteck(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public double getFlaeche() {
		double flaeche = this.width*this.height;
		return flaeche;
	}
}

class Kreis implements Figur {
	private final double x;
	private final double y;
	private final double radius;

	Kreis(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getFlaeche() {
		double flaeche=this.radius*this.radius*Math.PI;
		return flaeche;
	}
}

class Figuren {
	
	static double flaeche(Figur[] Figuren) {
		double flaeche=0;
		for (int i=0; i<Figuren.length; i++) {
			flaeche=flaeche+Figuren[i].getFlaeche();
		}
		return flaeche;
	}
}