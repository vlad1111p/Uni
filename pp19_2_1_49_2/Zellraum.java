public class Zellraum {
	private int zeilen;
	private int spalten;
	private int[][] array;

	public Zellraum(int zeilen, int spalten) {
		synchronized (this) {
			this.zeilen = zeilen;
			this.spalten = spalten;
			this.array = new int[zeilen][spalten];
		}
	}

	public synchronized int getzeilen() {
		return this.zeilen;
	}

	public synchronized int getspalten() {
		return this.spalten;
	}

	public synchronized int[][] getZellen() {
		

			return this.array;
		
	}

	void setZellen(int[][] neueZellen) {
		
			this.array = neueZellen;
		
	}

}
