
public class StringProcs {
	
	//tests
	public static void main(String[] args) {
		String f = "ftfh.123";
		System.out.println(extension(f));
		String s = ".a.";
		System.out.println(switchCommaAndDot(s));
		System.out.println(letterCount(s));
		System.out.println(wordCount(s));
	}
	
	//extension
	public static String extension(String f) {
		int position = f.lastIndexOf(".");
		String ausgabe;
		if( position == -1 ) {
			ausgabe = "";
		} else {
		    char[] fchar = f.toCharArray();
		    position = fchar.length - (position+1);
		    int z = 0;
		    for(int i = fchar.length - position; i < fchar.length; i++) { 
		    	z++;
		    }
		    char[] ausgabechar = new char[z];
		    int j = fchar.length - position;
		    for(int i = 0; i < position; i++) { 
		    	ausgabechar[i] = fchar[j];
		    	j++;
		    }
			ausgabe = String.valueOf(ausgabechar);
		}
	return ausgabe;
	}
	
	//switchCommaAndDot
	public static String switchCommaAndDot(String s) {
		String ausgabe;
		String punkte = s.replace(".", "sjqoqem22cnvasoafsa917kdlaf345kajsladkjd1aqoeoskdjaflakj");
		String komma = punkte.replace(",", ".");
		ausgabe = komma.replace("sjqoqem22cnvasoafsa917kdlaf345kajsladkjd1aqoeoskdjaflakj", ",");
	return ausgabe;	
	}
	
	//letterCount
	public static int letterCount(String s) {
		int ausgabe = 0;
		char[] schar = s.toCharArray();
		int z = 0;
		for(int i = 0; i < schar.length; i++) {
			if(Character.isLetter(schar[i])) {
				z++;
			}
		ausgabe = z;
		}
	return ausgabe;
	}
	
	//wordCount
	public static int wordCount(String s) {
		int ausgabe = 0;
		int z = 1;
		boolean bo = false;
		char[] schar = s.toCharArray();
		for(int i = 0; i < schar.length; i++) {
			if(Character.isLetter(schar[i])) {
				bo = true;
			} else if (bo ==true) {
				bo = false;
				z++;
			}
		}
		if(bo == false) {
			z--;
		}
		ausgabe = z;
		return ausgabe;
	}
	
}
