
import java.util.Scanner;

public class Caesar {

	public static String caesarenc(char[] input, int k) {
		String returnchar = "";

		for (int i = 0; i < input.length; i++) {
			if (Character.isLetter(input[i])) {
				if (Character.isUpperCase(input[i])) {
					input[i] = Character.toLowerCase(input[i]);
				}
				char character = (char) (((int) input[i] + k - 97) % 26 + 97);
				returnchar = returnchar + character;
			}
		}
		return returnchar;
	}

	public static void main(String[] args) {
		Scanner input1 = new Scanner(System.in);
		String text1 = input1.nextLine();
		int k = input1.nextInt();
		char[] text2 = text1.toCharArray();

		System.out.println(caesarenc(text2, k));
	}

}
