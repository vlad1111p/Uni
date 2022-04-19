import java.awt.Color;

public class Spielfeld {
    private int breite;
    private int hoehe;
    private Ball ball1; //Spielball
    private Ball ball2; 
    private Ball ball3;
    private int counterTry; //Versuche
    private static int counterWin; //Erfolge
    private double distanz12;
    private double distanz13;
    private double distanz23;
    private double distanz12new;
    private double distanz13new;
    private double distanz23new;

    public Spielfeld(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
        Vec2 position1 = new Vec2(breite/1.5,hoehe/2);
        Vec2 position2 = new Vec2(breite/2.5,hoehe/3);
        Vec2 position3 = new Vec2(breite/2.5,hoehe/1.5);
        Vec2 geschwindigkeit = new Vec2(0,0);
        Color farbe1 = new Color(255,255,255);
        Color farbe2 = new Color(255,0,0);
        double radius = 15;
        Ball ball1 = new Ball(position1, geschwindigkeit, farbe1, radius);
        this.ball1 = ball1;
        Ball ball2 = new Ball(position2, geschwindigkeit, farbe2, radius);
        this.ball2 = ball2;
        Ball ball3 = new Ball(position3, geschwindigkeit, farbe2, radius);
        this.ball3 = ball3;
        this.counterTry = 0;
        counterWin = 0;
    }

    /**
     * Wird von GUI verwendet um die Breite des Spielfelds zu bekommen.
     * (darf nicht entfernt werden)
     */
    public int getBreite() {
        return breite;
    }

    /**
     * Wird von GUI verwendet um die Hoehe des Spielfelds zu bekommen.
     * (darf nicht entfernt werden)
     */
    public int getHoehe() {
        return hoehe;
    }

    /**
     * Wird von Gui mehrmals pro Sekunde aufgerufen
     * (darf nicht entfernt werden)
     *
     * @param deltaT die Zeit in Sekunden seit dem letzten Aufruf der Methode
     */
    public void simulationsSchritt(double deltaT) {
    	if(ball1.position.distanceTo(ball2.position) <= ball1.radius*2 && distanz12 > distanz12new) { //if Baelle beruehren && baelle bewegen sich zueinander -> Kollision
    		Movement.collision(ball1, ball2);
    		Movement.setZug1(true);
    	} else if(ball1.position.distanceTo(ball3.position) <= ball1.radius*2 && distanz13 > distanz13new) {
    		Movement.collision(ball1, ball3);
    		Movement.setZug2(true);
    	} else if(ball2.position.distanceTo(ball3.position) <= ball1.radius*2 && distanz23 > distanz23new) {
    		Movement.collision(ball2, ball3);
    	} else {
    		if(ball1.geschwindigkeit.x != 0 || ball1.geschwindigkeit.y != 0) { //if Geschwindigkeit != 0 -> Reibung
        	Movement.newGeschwindigkeit(deltaT, ball1, hoehe, breite);
    		}
    		if(ball2.geschwindigkeit.x != 0 || ball2.geschwindigkeit.y != 0) {
        	Movement.newGeschwindigkeit(deltaT, ball2, hoehe, breite);
    		}
    		if(ball3.geschwindigkeit.x != 0 || ball3.geschwindigkeit.y != 0) {
        	Movement.newGeschwindigkeit(deltaT, ball3, hoehe, breite);
    		}
    	}
        distanz12 = ball1.position.distanceTo(ball2.position);
        distanz13 = ball1.position.distanceTo(ball3.position);
        distanz23 = ball2.position.distanceTo(ball3.position);
    	Vec2 pnew1 = ball1.position.plus((ball1.geschwindigkeit).mult(deltaT)); //neue Position
    	ball1.setPosition(pnew1);
    	Vec2 pnew2 = ball2.position.plus((ball2.geschwindigkeit).mult(deltaT));
    	ball2.setPosition(pnew2);
    	Vec2 pnew3 = ball3.position.plus((ball3.geschwindigkeit).mult(deltaT));
    	ball3.setPosition(pnew3);
    }

    /**
     * Wird von Gui immer nach simulationsSchritt aufgerufen um das Fenster zu zeichnen.
     * (darf nicht entfernt werden)
     *
     * @param seg ein Objekt zum zeichnen auf die Zeichenflaeche
     */
    public void zeichnen(SEGraphics seg) {
    	seg.reset(new Color(0, 150, 40));
    	seg.drawCircle(ball1.position.x, ball1.position.y, ball1.radius, ball1.farbe);
        seg.drawCircle(ball2.position.x, ball2.position.y, ball1.radius, ball2.farbe);
        seg.drawCircle(ball3.position.x, ball3.position.y, ball1.radius, ball2.farbe);
        String versuche = "Versuche: " + Integer.toString(this.counterTry);
        String erfolge = "Erfolge: " + Integer.toString(counterWin);
        seg.drawString(versuche, 25, 25, ball1.farbe);
        seg.drawString(erfolge, 25, 50, ball1.farbe);
        distanz12new = ball1.position.distanceTo(ball2.position);
        distanz13new = ball1.position.distanceTo(ball3.position);
        distanz23new = ball2.position.distanceTo(ball3.position);
    }

    /**
     * Wird von Gui immer dann aufgerufen, wenn mit der Maus auf das Spielfeld geklickt wurde
     * (darf nicht entfernt werden)
     *
     * @param x die x-Koordinate des Klicks
     * @param y die y-Koordinate des Klicks
     */
    public void mouseClicked(int x, int y) {
    	Vec2 klickpos = new Vec2(x,y);
    	if(	  ball1.geschwindigkeit.x < 0.2 && ball1.geschwindigkeit.y < 0.2
    	   && ball2.geschwindigkeit.x < 0.2 && ball2.geschwindigkeit.y < 0.2
    	   && ball3.geschwindigkeit.x < 0.2 && ball3.geschwindigkeit.y < 0.2
    	   && ball1.geschwindigkeit.x > -0.2 && ball1.geschwindigkeit.y > -0.2
    	   && ball2.geschwindigkeit.x > -0.2 && ball2.geschwindigkeit.y > -0.2
    	   && ball3.geschwindigkeit.x > -0.2 && ball3.geschwindigkeit.y > -0.2) {
    		Vec2 vnew1 = new Vec2(0,0);
    		vnew1 = klickpos.minus(ball1.position);
    		ball1.setGeschwindigkeit(vnew1);
    		counterTry++;
    		Movement.checkCounter();
    	}
    }
    
	
	public static int getCounterWin() {
		return counterWin;
	}
	
	public static void setCounterWin(int cW) {
		counterWin = cW;
	}
	
}
