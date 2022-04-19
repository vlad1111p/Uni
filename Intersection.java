public class Intersection {
    /*
    requires a != null
    modifies \nothing
    ensures \result == (es existiert ein int i in [0,a.length-1], so dass a[i] == x)
    */
    public static boolean contains(int[] a, int x) {
    	boolean ausgabe = false;
    	for (int i=0; i< a.length; i++) {
    		if(a[i] == x) {
    			ausgabe = true;
    			break;
    		} else {
    			ausgabe = false;
    		}
    	}
	  return ausgabe;
    }

    /*
    requires a != null
    modifies \nothing
    ensures \result == (fuer alle int i in [0,a.length-2]: a[i] < a[i+1])
    */
    public static boolean increasing(int[] a) {
    	boolean ausgabe = true;
    	for (int i=0; i< a.length-1; i++) {
    		if(a[i] >= a[i+1]) {
    			ausgabe = false;
    			break;
    		}
    	}
        return ausgabe;
    }

    /*
    requires a != null
          && b != null
          && increasing(a)
          && increasing(b)
    modifies \nothing
    ensures \result == (fuer alle int x: !contains(a, x) || contains(b,x))
    */
    public static boolean subset(int[] a, int[] b) {
    	boolean ausgabe = true;
    	for(int i=0; i<a.length; i++) {
          if( !contains(b,a[i]) ) {
        	ausgabe = false;
        	break;
          }
    	}
    	return ausgabe;
      }

    /*
    requires a != null
          && b != null
          && increasing(a)
          && increasing(b)
    modifies \nothing
    ensures \result != null
         && (fuer alle int x: (contains(a, x) && contains(b, x)) == contains(\result, x))
         && increasing(\result)
    */
    public static int[] intersection(int[] a, int[] b) {
    	int[] ausgabe = new int[0];
    	int[] speicher = new int[0];
    	if(increasing(a) && increasing(b)) {
    		for(int i=0; i<a.length; i++) {
    			if( contains(b,a[i]) ) {
    				speicher = new int[ausgabe.length+1];
            			for(int z=0; z < speicher.length-1; z++) {
            				speicher[z] = ausgabe[z];
            			}
            		speicher[speicher.length-1] = a[i];
            		ausgabe = new int[speicher.length];
            			for(int z=0; z < ausgabe.length; z++) {
            				ausgabe[z]=speicher[z];
            			}
    			}
    		}
    	}
    	return ausgabe;
    }
}