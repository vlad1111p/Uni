public class IsStronglyMonotonicIncreasing3 {
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		double z = Double.parseDouble(args[2]);
		boolean b;
			if (x < y && y < z) {
				b = true;
			} else {
				b = false;
			}
		System.out.println(b);
	}
}