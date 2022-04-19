public class BeatTheNeighbours {

	public static int strategy(int[] boxes) {
		int l = 0;
		int h = boxes.length - 1;
		int m = 0;
		while (l != h) {
			m = (l + h) / 2;
			if (boxes[m] <= boxes[m + 1]) {
				l = m + 1;
			} else {
				h = m;
			}
		}
		return h;
	}
}
