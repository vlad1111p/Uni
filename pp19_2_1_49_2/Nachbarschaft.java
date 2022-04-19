public class Nachbarschaft {
	private boolean set;

	Nachbarschaft() {

	}

	synchronized void setMoore() {
		this.set = true;
	}

	synchronized void setVonNeumann() {
		this.set = false;
	}

	public synchronized boolean getb() {

		return set;
	}

}
