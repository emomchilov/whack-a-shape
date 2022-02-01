package game;

import student.TestableRandom;

/**
 * This class tests the methods in the SimpleArrayBag class.
 * 
 * @author meden97
 * @version 19.09.2018
 *
 */
public class SimpleLinkedBagTest extends student.TestCase {

    private SimpleLinkedBag<Object> testerBag;
    private Object obj;
    private Object obj2;
    private Object obj3;


    /**
     * Sets up the circumstances before each test.
     */
    public void setUp() {
        testerBag = new SimpleLinkedBag<Object>();
        obj = new Object();
        obj2 = new Object();
        obj3 = new Object();
    }


    /**
     * Tests the add() method.
     */
    public void testAdd() {
        obj = null;
        assertFalse(testerBag.add(null));
        assertTrue(testerBag.add(obj2));
        assertEquals(1, testerBag.getCurrentSize());
    }


    /**
     * Tests the getCurrentSize() method.
     */
    public void testGetCurrentSize() {
        testerBag.add(obj);
        testerBag.add(obj2);
        testerBag.add(obj3);
        assertEquals(3, testerBag.getCurrentSize());
    }


    /**
     * Tests to see if the isEmpty method returns true.
     */
    public void testIsEmpty() {
        assertTrue(testerBag.isEmpty());
    }


    /**
     * Tests the pick method when the list is empty.
     */
    public void testPickNull() {
        assertNull(testerBag.pick());
    }


    /**
     * Tests the pick method when the list contains values.
     */
    public void testPick() {
        testerBag.add(obj);
        testerBag.add(obj2);
        testerBag.add(obj3);

        TestableRandom.setNextInts(2);
        assertEquals(obj, testerBag.pick());

    }


    /**
     * Tests the remove method if the list is empty.
     */
    public void testRemove() {
        assertFalse(testerBag.remove(obj));
    }


    /**
     * Tests the remove method if the list of 3 removes one
     * entry to be 2.
     */
    public void testRemove2() {
        testerBag.add(obj);
        testerBag.add(obj2);
        testerBag.add(obj3);

        assertTrue(testerBag.remove(obj));
        assertEquals(2, testerBag.getCurrentSize());
    }
}
