
public class Euclid {

	// rekursiv
	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		} else if (b == 0) {
			return a;
		} else if (a > b) {
			return gcd(a - b, b);
		} else {
			return gcd(a, b - a);
		}
	}

	public static int gcd2(int a, int b) {
		int i = a;
		int j = b;
		
		while (i != 0 && j != 0) {
			if (i>j) {
				i = i - j;
			} else {
				j = j - i;
			}
		}	
		if (i>j) {
			return i;
		} else {
			return j;
		}
	}

}