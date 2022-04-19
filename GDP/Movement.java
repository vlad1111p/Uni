
public class Movement {
	private static boolean zug1;
	private static boolean zug2;
	private static int counterCheck = 1;
	
	//Kollision
	public static void collision(Ball ballA, Ball ballB) {
		double a = (ballA.geschwindigkeit.minus(ballB.geschwindigkeit).skalarProdukt((ballA.position.minus(ballB.position))))/
					((ballA.position.minus(ballB.position)).length()*(ballA.position.minus(ballB.position)).length());
		Vec2 a2 = ballA.position.minus(ballB.position);
		Vec2 a3 = a2.mult(a);
		Vec2 vnewa = ballA.geschwindigkeit.minus(a3);
		double b = (ballB.geschwindigkeit.minus(ballA.geschwindigkeit).skalarProdukt((ballB.position.minus(ballA.position))))/
				((ballB.position.minus(ballA.position)).length()*(ballB.position.minus(ballA.position)).length());
		Vec2 b2 = ballB.position.minus(ballA.position);
		Vec2 b3 = b2.mult(b);
		Vec2 vnewb = ballB.geschwindigkeit.minus(b3);
		ballA.setGeschwindigkeit(vnewa);
		ballB.setGeschwindigkeit(vnewb);
	}
	
	public static void changeGeschwindigkeitIf(Vec2 v, Ball ball, int hoehe, int breite) {
		if((ball.position.x + ball.radius) < breite && (ball.position.x - ball.radius) > 0 &&  //if Ball im Feld, setze Geschwindigkeit
		   (ball.position.y + ball.radius) < hoehe && (ball.position.y - ball.radius) > 0) {
				ball.setGeschwindigkeit(v);
		}
		double switchX = v.x;
		double switchY = v.y;
		if((ball.position.x + ball.radius) >= breite && ball.geschwindigkeit.x > 0) { //if Ball nicht im Feld, invertiere Geschwindigkeit (falls noch nicht geschehen)
			switchX = -(v.x);
		}
		if((ball.position.x - ball.radius) <= 0 && ball.geschwindigkeit.x < 0) {
			switchX = -(v.x);
		}
		if((ball.position.y + ball.radius) >= hoehe && ball.geschwindigkeit.y > 0){
			switchY = -(v.y);
		}
		if((ball.position.y - ball.radius) <= 0 && ball.geschwindigkeit.y < 0) {
			switchY = -(v.y);
		}
		Vec2 switchV = new Vec2(switchX, switchY);
		ball.setGeschwindigkeit(switchV);
		if(zug1==true && zug2==true && Spielfeld.getCounterWin() != counterCheck) {
			Spielfeld.setCounterWin(counterCheck);
		}
	}
	
	//Reibung
	public static void newGeschwindigkeit(double deltaT, Ball ball,int hoehe,int breite) {
		Vec2 vnew = ball.geschwindigkeit;
    	double d = (20*deltaT)/(ball.geschwindigkeit.length());
    	vnew = vnew.minus(ball.geschwindigkeit.mult(d));
    	changeGeschwindigkeitIf(vnew, ball, hoehe, breite);
	}
	
	public static void checkCounter() {
		if(zug1==true && zug2==true) {
			counterCheck++;
		}
	    zug1 = false;
	    zug2 = false;
	}
	
	public static void setZug1(boolean zug) {
		zug1 = zug;
	}
	
	public static void setZug2(boolean zug) {
		zug2 = zug;
	}

}
