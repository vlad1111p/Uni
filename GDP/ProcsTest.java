import org.junit.Test;
import static org.junit.Assert.*;

public class ProcsTest {

	// Tests fuer take
	@Test
	public void takeTest1() {
		int[] ar = {1,2,3,4,5,6,7,8,9};
		int n = 3;
		assertArrayEquals(new int[]{1,2,3}, Procs.take(ar, n));
	}

	@Test
	public void takeTestnSameLength() {
		int[] ar = {4,-9,1};
		int n = 3;
		assertArrayEquals(new int[]{4,-9,1}, Procs.take(ar, n));
	}
	
	@Test
	public void takeTestzero() {
		int[] ar = {1,2,-103,4,5,6,7,8,9};
		int n = 0;
		assertArrayEquals(new int[]{}, Procs.take(ar, n));
	}
	
	// Tests fuer reverse
	@Test
	public void reverseTest1() {
		int[] input = {1,2,3,4,-5,6,7,8,9};
		Procs.reverse(input);
		assertArrayEquals(new int[]{9,8,7,6,-5,4,3,2,1}, input);
	}
	@Test
	public void reverseTestonly1() {
		int[] input = {1};
		Procs.reverse(input);
		assertArrayEquals(new int[]{1}, input);
	}
	
	@Test
	public void reverseTestleer() {
		int[] input = {};
		Procs.reverse(input);
		assertArrayEquals(new int[]{}, input);
	}

	// Tests für repeat
	@Test
	public void repeatTest1() {
		int[] snippet = {1,2,3};
		int len = 13;
		assertArrayEquals(new int[]{1,2,3,1,2,3,1,2,3,1,2,3,1}, Procs.repeat(snippet, len));
	}
	
	@Test
	public void repeatTestlen0() {
		int[] snippet = {1,2,3,4,5,6};
		int len = 0;
		assertArrayEquals(new int[]{}, Procs.repeat(snippet, len));
	}
	
	@Test
	public void repeatTestsnippetzero() {
		int[] snippet = {0};
		int len = 4;
		assertArrayEquals(new int[]{0,0,0,0}, Procs.repeat(snippet, len));
	}
}
