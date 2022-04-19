public class Logarithmus {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int z = b;
		int n = 0;
			while (b <= x) {
				b = b*z;
				++n;
			}
		System.out.println(n);
	}
}