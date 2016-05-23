import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack testStack;

    @Before
    public void setUp() {
        testStack = new Stack(5);
    }

    @After
    public void tearDown() {
        testStack = null;
    }

    @Test
    public void testGetItemCount() {
        assertEquals(0, testStack.getItemCount());
        testStack.push("zero");
        assertEquals(1, testStack.getItemCount());

    }

    @Test
    public void testPush() {

        testStack.push("zero");
        assertEquals(1, testStack.getItemCount());
        fillStack();
        assertEquals(5, testStack.getItemCount());
        testStack.push("full");
        assertEquals(5, testStack.getItemCount());
        assertNotEquals("full", testStack.pop());
    }

    @Test
    public void testPop() {
        assertEquals("Empty stack", testStack.pop());
        fillStack();
        assertEquals("4", testStack.pop());
    }

    private void fillStack() {
        while (testStack.getItemCount() < testStack.getStackCapacity()) {
            testStack.push((Integer.toString(testStack.getTopOfStack() + 1)));
        }
        testStack.displayStack();
    }
}