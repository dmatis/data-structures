import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {

    private Queue testQueue;

    @Before
    public void setUp() {
        testQueue = new Queue(5);
    }

    @After
    public void tearDown() {
        testQueue = null;
    }

    @Test
    public void testEnqueue() {
        testQueue.enqueue("zero");
        assertEquals(1, testQueue.getItemCount());
        testQueue.enqueue("one");
        assertEquals(2, testQueue.getItemCount());
    }

    @Test
    public void testDequeue() {
        testQueue.enqueue("zero");
        assertEquals("zero", testQueue.dequeue());
        assertEquals(0, testQueue.getItemCount());
    }

    @Test
    public void testDequeueFirstItem() {
        testQueue.enqueue("zero");
        testQueue.enqueue("one");
        assertEquals("zero", testQueue.dequeue());
        assertEquals(1, testQueue.getItemCount());
    }

    @Test
    public void testFillQueue() {
        fillQueue();
        assertEquals(5, testQueue.getItemCount());
    }

    @Test
    public void testFullQueue() {
        try {
            fillQueue();
            testQueue.enqueue("6");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Sorry, Queue is full", e.getMessage());
        } finally {
            assertEquals(5, testQueue.getItemCount());
        }
    }

    private void fillQueue() {
        while (testQueue.getItemCount() < testQueue.getQueueCapacity()) {
            testQueue.enqueue((Integer.toString(testQueue.getBackIndex() + 1)));
        }
        testQueue.displayQueue();
    }
}