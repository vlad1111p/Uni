package beatpssaf;

import java.util.Arrays;

public class Palindrome {
	public static boolean isPalindrome(char[] a) {
		
		
		if (a.length < 2) {
            // all strings with 0 or 1 characters are palindromes
            return true;
        }

		
		if(Character.toLowerCase(a[0]) != Character.toLowerCase(a[a.length-1])) {
            // the first and last characters are different therefore the word is not a palindrome
            return false;
        }

        return isPalindrome(Arrays.copyOfRange(a, 1, a.length - 1));
    }

	}
