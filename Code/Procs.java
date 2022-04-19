import java.util.Arrays;

public class Procs {
	public static void main(String[] args) {
		int[] a = {1,2,3,10,9,8,7,6,5,4};
		int len = 4;
		System.out.println(Arrays.toString(take(a, len)));  
		System.out.println(a.length);
		int[] res1;
		int[] b = {0};
		res1 = repeat(b, len);
		reverse(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(res1));
	}
	/* 
	requires ar != null
	      && n >= 0
	      && n <= ar.length
	modifies \nothing
	ensures \result = (\result[0 bis n] == ar[0 bis n]) 
	*/
    public static int[] take(int[] ar, int n) {
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = ar[i];
        }        
        return res;
    }
    
    /*
    requires input != null
    modifies input
    ensures  \result = (input Array wird invertiert)
    */
    public static void reverse(int[] input) {
        for (int i=0; i<input.length/2; i++) {
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
    }

    /*
    requires snippet!=null 
    	  && len >= 0
    modifies \nothing
    ensures \result = (neues Array \result[len] mit \result[0 bis snippet.length] == snippet[0 bis snippet.length]
    und if len > snippet.length -> dann wird jeder Wert darüber wiederholt, also \result[snippet.length+1] == snippet[0], \result[snippet.length+2] == snippet[1] usw bis \result[len])
    */
    public static int[] repeat(int[] snippet, int len) {
        int[] res = new int[len];
        int resPos = 0;
        while (resPos < len) {
            for (int i=0; i < snippet.length && resPos < len; i++) {
                res[resPos] = snippet[i];
                resPos = resPos + 1;
            }
        }
        return res;
    }
}