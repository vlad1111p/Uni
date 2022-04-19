public class Range {
	public static void main(String[] args) {
		int start = Integer.parseInt(args[0]);
		int end   = Integer.parseInt(args[1]);
		int step  = Integer.parseInt(args[2]);
		
		int i = start;
		if (step > 0) {		
		while (i < end) {
			System.out.println(i);
			i = i + step;
		}
		} else if (step < 0 && end + step <= start){
		while (i > end) {
			System.out.println(i);
			i = i + step;
		}
		}
	}
}