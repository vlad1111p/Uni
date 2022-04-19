package priorityqueue;


import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingleLinkedListTest {

	private PriorityQueue<Integer> sll;

	@BeforeEach
	void initAnewBeforeEach() {
		sll = new SingleLinkedList<Integer>(Comparator.naturalOrder());
	}

	@Test
	void minimalTest() {
		sll.insert(0);
		assertEquals(0, sll.deleteMin().intValue());
	}

	@Test
	void simpleInsertionDeletionGetTest() {
		sll.insert(2);
		sll.insert(4);
		sll.insert(20);
		sll.insert(1);
		sll.insert(5);

		assertEquals(1, sll.getMin().intValue());
		assertEquals(1, sll.deleteMin().intValue());
		assertEquals(2, sll.getMin().intValue());
		assertEquals(2, sll.deleteMin().intValue());
		assertEquals(4, sll.getMin().intValue());
		assertEquals(4, sll.deleteMin().intValue());
		assertEquals(5, sll.getMin().intValue());
		assertEquals(5, sll.deleteMin().intValue());
		assertEquals(20, sll.getMin().intValue());
		assertEquals(20, sll.deleteMin().intValue());
		assertTrue(sll.isEmpty());
	}

	@Test
	void simpleInsertionGetTest() {
		for (int i = 100; i > 0; i--) {
			sll.insert(-i);
			assertEquals(-100, sll.getMin().intValue());
		}
	}

	@Test
	void simpleInsertionDeletionTest() {
		for (int i = 100; i > 0; i--) {
			sll.insert(-i);
		}
		for (int i = 100; i > 0; i--) {
			assertEquals(-i, sll.deleteMin().intValue());
		}
	}

	@Test
	void simpleMergeTest() {
		PriorityQueue<Integer> lt2m = new SingleLinkedList<Integer>(Comparator.naturalOrder());
		for (int i = 1; i < 100; i += 2) {
			sll.insert(i);
			lt2m.insert(i - 1);
		}
		sll.merge(lt2m);
		for (int i = 0; i < 100; i++) {
			assertEquals(i, sll.deleteMin().intValue());
		}
	}
	
	@Test
	void mergeEmtpyTest1() {
		PriorityQueue<Integer> lt2m = new SingleLinkedList<Integer>(Comparator.naturalOrder());
		for (int i = 1; i < 100; i += 2) {
			lt2m.insert(i - 1);
		}
		sll.merge(lt2m);
		for (int i = 0; i < 99; i += 2) {
			assertEquals(i, sll.deleteMin().intValue());
		}
	}
	
	@Test
	void mergeEmtpyTest2() {
		PriorityQueue<Integer> lt2m = new SingleLinkedList<Integer>(Comparator.naturalOrder());
		sll.merge(lt2m);
		assertTrue(sll.isEmpty());
	}
	
	@Test
	void mergeEmtpyTest3() {
		PriorityQueue<Integer> lt2m = new SingleLinkedList<Integer>(Comparator.naturalOrder());
		for (int i = 100; i > 0; i--) {
			sll.insert(-i);
		}
		sll.merge(lt2m);
		for (int i = 100; i > 0; i--) {
			assertEquals(-i, sll.deleteMin().intValue());
		}
	}

}
