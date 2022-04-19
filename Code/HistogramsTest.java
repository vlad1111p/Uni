import static org.junit.Assert.*;

import org.junit.Test;

public class HistogramsTest {

	//werte
	@Test
	public void werteTestStandard() {
		String[] ar = {"0","2","3","2"};
		assertArrayEquals(new int[]{2, 2}, Histograms.werte(ar));
	}
	
	@Test
	public void werteTestEmpty() {
		String[] ar = {};
		assertArrayEquals(new int[]{}, Histograms.werte(ar));
	}
	
	@Test
	public void werteTestMinus() {
		String[] ar = {"1290","-214","3","0"};
		assertArrayEquals(new int[]{-214, 0}, Histograms.werte(ar));
	}
	
	@Test
	public void werteTestOnlyOne() {
		String[] ar = {"0"};
		assertArrayEquals(new int[]{}, Histograms.werte(ar));
	}
	
	//min
	@Test
	public void minTestStandard() {
		int[] ar = {2,3,4,-12,12,14,-11,-13};
		assertEquals(-13 , Histograms.min(ar));
	}
	
	@Test
	public void minTestOnlyOne() {
		int[] ar = {12};
		assertEquals(12 , Histograms.min(ar));
	}
	
	@Test
	public void minTestMultiple() {
		int[] ar = {-13,3,4,-13,12,14,-11,-13};
		assertEquals(-13 , Histograms.min(ar));
	}
	
	//max
	@Test
	public void maxTestStandard() {
		int[] ar = {2,3,4,-12,12,14,-11,18};
		assertEquals(18 , Histograms.max(ar));
	}
	
	@Test
	public void maxTestOnlyOne() {
		int[] ar = {12};
		assertEquals(12 , Histograms.max(ar));
	}
	
	@Test
	public void maxTestMultiple() {
		int[] ar = {12,3,12,-12,12,12,-11,-13};
		assertEquals(12 , Histograms.max(ar));
	}
	
	//counts
	@Test
	public void countsStandard() {
		int min = 15;
		int max = 100;
		int[] values = {15,18,20,34,45,56,64,75,82,95,100};
		int amount = 5;
		assertArrayEquals(new int[]{3,2,2,2,2}, Histograms.counts(min, max, values, amount));
	}
	
	@Test
	public void countsTestOnlyAllSameValue() {
		int min = 1;
		int max = 5;
		int[] values = {5, 5, 5, 5, 5};
		int amount = 5;
		assertArrayEquals(new int[]{0,0,0,0,5}, Histograms.counts(min, max, values, amount));
	}
	
	@Test
	public void countsTestHighDifference() {
		int min = 1;
		int max = 1000;
		int[] values = {2,999};
		int amount = 3;
		assertArrayEquals(new int[]{1,0,1}, Histograms.counts(min, max, values, amount));
	}
	
	@Test
	public void countsTestNegative() {
		int min = -20;
		int max = 30;
		int[] values = {10,15,-20,25,30};
		int amount = 5;
		assertArrayEquals(new int[]{1,0,1,1,2}, Histograms.counts(min, max, values, amount));
	}
		
	//normalize
	@Test
	public void normalizeTestStandard() {
		int[] counts = {20,30,40,50,60,70,80};
		assertArrayEquals(new int[]{20*50/80,30*50/80,40*50/80,50*50/80,60*50/80,70*50/80,80*50/80}, Histograms.normalize(counts));
	}
	
	@Test
	public void normalizeTestOnlyOne() {
		int[] counts = {11};
		assertArrayEquals(new int[]{11*50/11}, Histograms.normalize(counts));
	}
	
	@Test
	public void normalizeTestNegative() {
		int[] counts = {-24,-31};
		assertArrayEquals(new int[]{-24*50/-24, -31*50/-24}, Histograms.normalize(counts));
	}
	
	//ausgabe (new int = eingabe, da Wert nicht verändert wird)
	@Test
	public void ausgabeTestOnlyZero() {
		int[] normalizedCounts = {0};
		Histograms.ausgabe(normalizedCounts);
		assertArrayEquals(new int[]{0}, normalizedCounts);
	}
	
	@Test
	public void ausgabeTestNegative() {
		int[] normalizedCounts = {-255,421};
		Histograms.ausgabe(normalizedCounts);
		assertArrayEquals(new int[]{-255,421}, normalizedCounts);
	}
}
