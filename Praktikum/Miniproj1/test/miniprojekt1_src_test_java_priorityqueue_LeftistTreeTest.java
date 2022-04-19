package priorityqueue;


import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeftistTreeTest {

    private PriorityQueue<Integer> lt;

    @BeforeEach
    void initAnewBeforeEach() {
        lt = new LeftistTree<Integer>(Comparator.naturalOrder());
    }

    @Test
    void isEmptyTest() {
        assertTrue(lt.isEmpty());
    }

    @Test
    void simpleInsertionDeletionGetTest() {
        lt.insert(2);
        lt.insert(4);
        lt.insert(20);
        lt.insert(1);
        lt.insert(5);

        assertEquals(1, lt.getMin().intValue());
        assertEquals(1, lt.deleteMin().intValue());
        assertEquals(2, lt.getMin().intValue());
        assertEquals(2, lt.deleteMin().intValue());
        assertEquals(4, lt.getMin().intValue());
        assertEquals(4, lt.deleteMin().intValue());
        assertEquals(5, lt.getMin().intValue());
        assertEquals(5, lt.deleteMin().intValue());
        assertEquals(20, lt.getMin().intValue());
        assertEquals(20, lt.deleteMin().intValue());
        assertTrue(lt.isEmpty());
    }

    @Test
    void simpleInsertionGetTest() {
        for (int i = 100; i > 0; i--) {
            lt.insert(-i);
            assertEquals(-100, lt.getMin().intValue());
        }
    }

    @Test
    void simpleInsertionDeletionTest() {
        for (int i = 100; i > 0; i--) {
            lt.insert(-i);
        }
        for (int i = 100; i > 0; i--) {
            assertEquals(-i, lt.deleteMin().intValue());
        }
    }

    @Test
    void simpleMergeTest() {
        PriorityQueue<Integer> lt2m = new LeftistTree<Integer>(Comparator.naturalOrder());
        for (int i = 1; i < 100; i += 2) {
            lt.insert(i);
            lt2m.insert(i - 1);
        }
        lt.merge(lt2m);
        for (int i = 0; i < 100; i++) {
            assertEquals(i, lt.deleteMin().intValue());
        }
    }

    @Test
    void mergeEmtpyTest1() {
        PriorityQueue<Integer> lt2m = new LeftistTree<Integer>(Comparator.naturalOrder());
        for (int i = 1; i < 100; i += 2) {
            lt2m.insert(i - 1);
        }
        lt.merge(lt2m);
        for (int i = 0; i < 99; i += 2) {
            assertEquals(i, lt.deleteMin().intValue());
        }
    }

    @Test
    void mergeEmtpyTest2() {
        PriorityQueue<Integer> lt2m = new LeftistTree<Integer>(Comparator.naturalOrder());
        lt.merge(lt2m);
        assertTrue(lt.isEmpty());
    }

    @Test
    void mergeEmtpyTest3() {
        PriorityQueue<Integer> lt2m = new LeftistTree<Integer>(Comparator.naturalOrder());
        for (int i = 100; i > 0; i--) {
            lt.insert(-i);
        }
        lt.merge(lt2m);
        for (int i = 100; i > 0; i--) {
            assertEquals(-i, lt.deleteMin().intValue());
        }
    }

}
