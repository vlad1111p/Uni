import java.util.Stack;

public class Polnisch {
	public static void main(String[] args) {
		Stack<Integer> stapel = new Stack<Integer>();
		int first = 0;
		int second = 0;
		while(!StdIn.isEmpty()) {
			String s = new String(StdIn.readString());
			if(s.equals("+")&& stapel.size() >= 2) {
				first = stapel.pop();
				second = stapel.pop();
				stapel.push(second+first);
			} else if(s.equals("-")&& stapel.size() >= 2) {
				first = stapel.pop();
				second = stapel.pop();
				stapel.push(second-first);
			} else if(s.equals("*")&& stapel.size() >= 2) {
				first = stapel.pop();
				second = stapel.pop();
				stapel.push(second*first);
			} else if(s.equals("/")&& stapel.size() >= 2) {
				first = stapel.pop();
				second = stapel.pop();
				stapel.push(second/first);
			} else {
				stapel.push(Integer.parseInt(s));
			}
		}
		if(stapel.size()>0) {
			System.out.println(stapel.pop());
		}
	}
}
