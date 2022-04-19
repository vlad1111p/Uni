public class Histograms {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Geben Sie die Anzahl der Segmente "
                + "im Histogramm als Programmparameter an.");
            return;
        }
             
        
        // Werte von Eingabe lesen (immer Bezeichnung mit Wert)
        String[] input = ReadStrings.readStrings();
        if (input.length < 2) {
            System.out.println("Keine Werte eingegeben.");
            return;
        }
        

    	int[] values=werte(input);
    	int min=min(values);
    	int max=max(values);
    	int amount=Integer.parseInt(args[0]);
        int[] counts=counts(min, max, values, amount);
        int[] normalizedCounts=normalize(counts);
        ausgabe(normalizedCounts);
    }
    
    // Werte aus Eingaben extrahieren (jeder zweite Wert)    
    static int[] werte (String[] input) {
    	int[] values = new int[input.length / 2];
    	for (int i = 0; i < values.length; i++) {
    		values[i] = Integer.parseInt(input[i * 2 + 1]);
    	}    	
    	return values;
    }

    // Kleinsten Wert berechnen:
    static int min(int[] values) {
    	int min = values[0];
    	for (int i = 1; i < values.length; i++) {
        	if (values[i] < min) {
        		min = values[i];
        	}
    	}
    	return min;
    }    
    
    // Größten Wert berechnen:
    static int max (int[] values) {
    	int max = values[0];
    	for (int i = 1; i < values.length; i++) {
    		if (values[i] > max) {
    			max = values[i];
    		}
    	}
    	return max;
    }

    // Die Anzahl der Werte für jedes Segment berechnen:
    static int[] counts (int min, int max, int[] values, int amount) {
        
    	int[] counts = new int[amount];
    	// Abstand zwischen min und max:
    	int range = (max - min);    
    
    	for (int i2 = 0; i2 < values.length; i2++) {
        	int section = (values[i2] - min) * amount / (range+1);
        	counts[section] = counts[section] + 1;
    	}
    	return counts;
    }

    // Werte so normalisieren, dass 50 der Maximalwert ist:
    static int[] normalize(int[] counts) {
    	int[] normalizedCounts = new int[counts.length];
    	int res = counts[0];
    	for (int i = 1; i < counts.length; i++) {
    		if (counts[i] > res) {
    			res = counts[i];
    		}
    	}
    	int maxCount = res;
		for (int i1 = 0; i1 < counts.length; i1++) {
    		normalizedCounts[i1] = counts[i1] * 50 / maxCount;
    	}
		return normalizedCounts;
    }

    // Histogramm als Balken auf der Konsole ausgeben:
    static void ausgabe(int[] normalizedCounts) {
    	for (int i = 0; i < normalizedCounts.length; i++) {
    		int n = normalizedCounts[i];
    		for (int j = 0; j < n; j++) {
    			System.out.print("|");
    		}
    		System.out.println();
    	}
    
    }
}
