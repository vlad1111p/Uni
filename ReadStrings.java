import java.util.Arrays;

public class ReadStrings {

    public static void main(String[] args) {
	String[] x = readStrings();
	System.out.println(Arrays.toString(x));
    }

    public static String[] readStrings() {
	int i = 0;
	String[] a = new String[0];
	String[] b = new String[0];
	  while (!StdIn.isEmpty()) {
	    if (a.length <= i) {
	      b = new String[a.length+1];
	      for (int z = 0; z < a.length; z++) {
	    	b[z] = a[z];
	      }
	      a = new String[b.length];
	      for (int z = 0; z < a.length-1; z++) {
	    	a[z] = b[z];
	      }
	    }
	  String s = StdIn.readString();
	  a[i] = s;
	  i++;
	  }
      return a;
    }
}