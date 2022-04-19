import java.io.IOException;
import java.io.Reader;

public class WordStream implements StringStream {
	Reader reader;
	
	WordStream(Reader reader) {
		this.reader = reader;
	}
	
	@Override
	public String read() throws IOException {
		String ausgabe = new String();
		int position = 0;
		char[] charray = new char[0];
		char[] charcheck = new char[1];
		int check = 0;
		while(check != -1) {
				check = reader.read(charcheck);
				//ende des streams erreicht
				if(check == -1) {
					for(int i=0; i<charray.length; i++) {
						ausgabe += charray[i];
					}
					if(ausgabe.equals("")) {
						return null;
					}
					return ausgabe;
				}
				//ende des streams nicht erreicht
				if(Character.isLetter(charcheck[0])) {
					charray = higher(charray);
					charray[position] = charcheck[0];
					position++;
				} else if(charray.length > 0) {
					for(int i=0; i<charray.length; i++) {
						ausgabe += charray[i];
					}
					return ausgabe;
				}
					
		}
		return null;
	}
	
	private char[] higher(char[] a) {
		char[] ausgabe = new char[a.length +1];
		for(int i=0; i<a.length; i++) {
			ausgabe[i] = a[i];
		}
		return ausgabe;
	}

	
}
