import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CircularQueueTest {

    CircularQueue testQueue;

    @Before
    public void setUp() {
        testQueue = new CircularQueue();
    }

    @After
    public void tearDown() {
        testQueue = null;
    }

    @Test
    public void testIsFull() {
        testQueue.enqueue("A");
        assertFalse(testQueue.isFull());
        fillQueue();
        assertTrue(testQueue.isFull());
        testQueue.dequeue();
        assertFalse(testQueue.isFull());
    }

    @Test
    public void testDisplayQueue() {
        try {
            testQueue.displayQueue();
        } catch (QueueEmptyException e) {
            assertEquals("Sorry, Queue is empty", e.getMessage());
        }
    }

    @Test
    public void testEnqueue() {
        testQueue.enqueue("A");
        assertEquals(1, testQueue.size());
        fillQueue();
        assertEquals(testQueue.capacity(), testQueue.size());
        try {
            testQueue.enqueue("Z");
        } catch (QueueFullException e) {
            assertEquals("Sorry, Queue is full", e.getMessage());
        }
    }

    @Test
    public void testDequeue() {
        try {
            testQueue.dequeue();
        } catch (QueueEmptyException e) {
            assertEquals("Sorry, Queue is empty", e.getMessage());
        } finally {
            testQueue.enqueue("A");
            assertEquals("A", testQueue.dequeue());
            assertEquals(0, testQueue.size());
        }
    }

    private void fillQueue() {
        for (int i = 0; testQueue.size() < testQueue.capacity(); i++) {
            testQueue.enqueue(Integer.toString(i));
        }
    }
}