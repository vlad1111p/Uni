import java.util.Arrays;

public class ArraysAndProcedures {

public static void main(String[] args) {
        // Testen von Aufgabenteil a)
    	
    	System.out.println("Aufgabe a)");
        int[] aa = {1, 2, 3, 4, 5};
        replaceAll(3, 42, aa);
        System.out.println(Arrays.toString(aa));
        

        //Test von Aufgabe b)
        
        System.out.println("Aufgabe b)");
        int[] ab = {2, 2, 2, 2, 2};
        replaceFirst(2, 5, ab);
        System.out.println(Arrays.toString(ab));
        
	int[] ab2 = {2, 2, 2, 2, 2};
        replaceLast(2,5,ab2);
        System.out.println(Arrays.toString(ab2));
        
        //Test von Aufgabe c)
        
        System.out.println("Aufgabe c)");
        int[] ac1 = {1, 2, 3, 2, 4};
        int[] ac2 = substAll(2, 7, ac1);
        System.out.println(Arrays.toString(ac1)); // Gibt "[1, 2, 3, 2, 4]" aus
        System.out.println(Arrays.toString(ac2)); // Gibt "[1, 7, 3, 7, 4]" aus
        
        //Test von Aufgabe d)
        
        System.out.println("Aufgabe d)");
        int[] ad1 = {1, 3, 3, 3, 7, 3};
        int[] ad2 = onlyEven(ad1);
        System.out.println(Arrays.toString(ad1)); // Gibt "[1, 3, 2, 4, 7, 2]" aus
        System.out.println(Arrays.toString(ad2)); // Gibt "[2, 4, 2]" aus
        
        
        //Test von Aufgabe e)
        
        System.out.println("Aufgabe e)");
	int[][] a1 = {{1,2}, {0,7}, {7,0,7}};
	int[][] a2 = {{1,2,0}, {4,5,6}};
	int[][] a3 = {{0,2,0}, {0,7}, {7,0,7}};
	int[][] a4 = {{1,2,0}, {-7,4}, {7,0,7}, {0}};
	int[][] a5 = {{1,2,0}, {0,7}, {7,0,7}};
	System.out.println(allHaveZero(a1));
	System.out.println(allHaveZero(a2));
	System.out.println(allHaveZero(a3));
	System.out.println(allHaveZero(a4));
	System.out.println(allHaveZero(a5));
    }

    public static void replaceAll(int x, int y, int[] ar) {
	  for(int i = 0; i < ar.length; i++) {
		if(ar[i] == x) {
		  ar[i] = y;
		}
	  }
    }

    public static void replaceFirst(int x, int y, int[] ar) {
	  for(int i = 0; i < ar.length; i++) {
		if(ar[i] == x) {
		  ar[i] = y;
		  break;
		}
	  }
    }

    public static void replaceLast(int x, int y, int[] ar) {
	  for(int i = ar.length - 1; i >= 0; i--) {
		if(ar[i] == x) {
		  ar[i] = y;
		  break;
		}
	  }
    }

    public static int[] substAll(int x, int y, int[] ar) {
        int[] ar2 = new int[ar.length];
	  for(int i = 0; i < ar.length; i++) {
		if(ar[i] == x) {
		  ar2[i] = y;
		} else {
		  ar2[i] = ar[i];
		}
	  }
        return ar2;
    }

    public static int[] onlyEven(int[] ar) {
	int z = 0;
	  for(int i = 0; i < ar.length; i++) {
		if(ar[i] % 2 == 0) {
		  z++;
		}
	  }
	int[] ar2 = new int[z];
	int z2 = 0;
	   for(int i2 = 0; i2 < ar.length; i2++) {
		if(ar[i2] % 2 == 0) {
		  ar2[z2] = ar[i2] ;
		  z2++;
		}
	  }
        return ar2;
    }

    public static boolean allHaveZero(int[][] arrays) {
	int i = 0;
	int j = 0;
	int count = 0;
	boolean zero = false;
	
	while (i < arrays.length) {
		j = 0;
		zero = false;
		while (j < arrays[i].length) {
			if (arrays[i][j] == 0) {
			zero = true;
			}
			j++;
		}
		
		if (zero == true) {
			count++;
		}
		i++;

	}
	if (count == arrays.length) {
		return true;
	} else {
		return false;
    }
}



}