import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashMapTest {

    HashMap testHashMap;

    @Before
    public void setUp() {
        testHashMap = new HashMap();
    }

    @After
    public void tearDown() {
        testHashMap = null;
    }

    @Test
    public void testGet() {
        testHashMap.put(0, "zero");
        assertEquals("zero", testHashMap.get(null));
        testHashMap.put(1, "one");
        assertEquals("one", testHashMap.get(1));
        testHashMap.put(17, "seventeen");
        assertEquals("seventeen", testHashMap.get(17));
    }

    @Test
    public void testPut() {


    }
}