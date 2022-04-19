import java.awt.Color;

public class PicEdit {
	
	public static void main(String[] args) {
	// Interaktionsschleife
        boolean exit = false;
        do {
            StdOut.print("1. Berechnen der durchschnittlichen Schwarz-Weiß-Luminanz eines Bildes. \n"
            		+ "2. Ändern der Sättigung eines Bildes. \n"
            		+ "3. Drehen eines Bildes um 90° entgegen dem Uhzeigersinn. \n"
            		+ "exit \n");
            
            String action = StdIn.readString();
            switch (action) {
             case "exit":    exit = true; break;
             case "1" :      StdOut.println("Bitte Eingabe-Datei mit absolutem Pfad und Dateiendung angeben"); 
             			     Picture p = new Picture(StdIn.readString()); System.out.println(averageLum(p));
             			     System.out.println("Done"); break;
             case "2" :		 StdOut.println("Bitte Eingabe-Datei mit absolutem Pfad angeben"); 
             				 Picture q = new Picture(StdIn.readString());
             				 StdOut.println("Bitte Ausgabe-Datei mit absolutem Pfad angeben");
             				 String ausgabe = StdIn.readString();
             				 StdOut.println("Bitte Änderungswert der Saettigung angeben (Für Dezimalzahlen bitte . verwenden)");
             				 double wert = StdIn.readDouble();
             				 changeSaturation(q,wert);
             				 q.save(ausgabe);
             				 System.out.println("Done"); break;
             case "3" : 	 StdOut.println("Bitte Eingabe-Datei mit absolutem Pfad und Dateiendung angeben"); 
			     			 Picture r = new Picture(StdIn.readString());
			     			 StdOut.println("Bitte Ausgabe-Datei mit absolutem Pfad angeben");
            				 String ausgabe2 = StdIn.readString();
            				 Picture r2 = new Picture(rotatedLeft(r));
            				 r2.save(ausgabe2);
            				 System.out.println("Done"); break;
             default:        StdOut.println("Eingabe nicht bekannt");
            }
        } while(!exit);
    }

    //lum - Farbe - Schwarz-Weiss-Luminanz
	public static double lum(Color c) {
		double ausgabe = 0;
		int red = c.getRed();
		int green = c.getGreen();
		int blue = c.getBlue();
		ausgabe = 0.299*red+0.587*green+0.114*blue;
	return ausgabe;
	}
	
	//averageLum - Bild - durchschnittliche Schwarz-Weiss-Luminanz
	public static double averageLum(Picture p) {
		Color farbe = new Color(0,0,0);
		double ausgabe = 0.0;
		int q = 0;
		for(int i = 0; i < p.width(); i++) {
			for(int z = 0; z < p.height(); z++) {
				farbe = p.get(i,z);
				ausgabe = ausgabe + lum(farbe);
				q++;
			}
		}
	return ausgabe/q;
	}

	//changedColorSaturation - Farbe, Aenderungswert - Aendert Saettigung
	public static Color changedColorSaturation(Color c, double change) {
		Color ausgabe = new Color(0,0,0);
		double p = lum(c);
		int r = c.getRed();
		int g = c.getGreen();
		int b = c.getBlue();
		
		double r2 = Math.round(p + (r-p)*change);
		double g2 = Math.round(p + (g-p)*change);
		double b2 = Math.round(p + (b-p)*change);
		if(r2 > 255) {
			r2 = 255;
		} else if (r2 < 0) {
			r2 = 0;
		}
		if(g2 > 255) {
			g2 = 255;
		} else if (g2 < 0) {
			g2 = 0;
		}
		if(b2 > 255) {
			b2 = 255;
		} else if (b2 < 0) {
			b2 = 0;
		}
		
		int r3 = (int) r2;
		int g3 = (int) g2;
		int b3 = (int) b2;
		ausgabe = new Color(r3,g3,b3);
	
	return ausgabe;	
	}
	
	//changeSaturation - Bild, Wert - Aendert Saettigung
	public static void changeSaturation(Picture p, double change) {
		Color c = new Color(0,0,0);
		for(int i = 0; i < p.width(); i++) {
			for(int j = 0; j < p.height(); j++) {
				c = p.get(i, j);
				c = changedColorSaturation(c, change);
				p.set(i,j,c);
			}
		}
	}
	
	//rotateLeft - Bild - rotiert nach links
	public static Picture rotatedLeft(Picture p) {
		Picture ausgabe = new Picture(p.height(),p.width());
		Color a = new Color(0,0,0);
		for(int i = 0; i < p.width(); i++) {
			for(int j = 0; j < p.height(); j++) {
				a = p.get(i,j);
				ausgabe.set(j, ausgabe.height() -1 - i, a);
			}
		}
	return ausgabe;	
	}
}