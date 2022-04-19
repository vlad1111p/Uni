import java.util.Arrays;

public class SqrtTable {
	public static void main(String[] args) {
		double s;
		while(!StdIn.isEmpty()) {
		  s = StdIn.readDouble();
		  StdOut.printf("%.2f,%.2f%n", s, Math.sqrt(s));
		}
	}
}