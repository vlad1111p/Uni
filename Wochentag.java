public class Wochentag {
	public static void main(String[] args) {
		int t = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		int k;
		int jh = j/100;
		int nh;		
		int h;
		String s = "0";
		if (m <= 2) {
		m = m + 12;
		j = j - 1;
		}
		k = Math.floorMod(j, 100);

		nh = t+((13*(m+1)/5))+k+(k/4)+((jh)/4)-(2*(jh));
		h = nh%7;
		if (h == 0) {
			s = "Samstag";
		}	else if (h == 1) {
			s = "Sonntag";
		}	else if (h == 2) {
			s = "Montag";
		}	else if (h == 3) {
			s = "Dienstag";
		}	else if (h == 4) {
			s = "Mittwoch";
		}	else if (h == 5) {
			s = "Donnerstag"; 
		}	else if (h == 6) {
			s = "Freitag";
		}
	System.out.println(s);
	}
}