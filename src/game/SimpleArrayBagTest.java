package game;

import student.TestableRandom;

/**
 * This class tests the methods in the SimpleArrayBag class.
 * 
 * @author meden97
 * @version 19.09.2018
 *
 */
public class SimpleArrayBagTest extends student.TestCase {

    private SimpleArrayBag<Object> testerBag;
    private Object obj;
    private Object obj2;
    private Object obj3;


    /**
     * This sets up the circumstances before each test.
     */
    public void setUp() {
        testerBag = new SimpleArrayBag<>();
        obj = new Object();
        obj2 = new Object();
        obj3 = new Object();
    }


    /**
     * Tests the add method for the SimpleArrayBag when it has space.
     */
    public void testAdd() {
        assertTrue(testerBag.add(obj));
    }


    /**
     * Tests the add method for the SimpleArrayBag when it does not
     * have space.
     */
    public void testAddFalse() {
        for (int i = 0; i < 25; i++) {
            Object object = new Object();
            testerBag.add(object);
        }
        assertFalse(testerBag.add(obj2));
        assertEquals(25, testerBag.getCurrentSize());
    }


    /**
     * Tests the add method for the SimpleArrayBag when the object
     * being added is null.
     */
    public void testAddNull() {
        obj = null;
        assertFalse(testerBag.add(obj));
    }


    /**
     * Tests that the getCurrentSizeMethod returns the correct size.
     */
    public void testGetCurrentSize() {
        testerBag.add(obj);
        testerBag.add(obj2);
        testerBag.add(obj3);
        assertEquals(3, testerBag.getCurrentSize());
    }


    /**
     * Tests the isEmpty() method.
     */
    public void testIsEmpty() {
        assertTrue(testerBag.isEmpty());
        testerBag.add(obj);
        assertFalse(testerBag.isEmpty());
    }


    /**
     * Tests the pick() method if the array is empty.
     */
    public void testPickNull() {
        assertNull(testerBag.pick());
    }


    /**
     * Tests the pick() method if the array has entries.
     */
    public void testPick() {
        testerBag.add(obj);
        testerBag.add(obj2);
        testerBag.add(obj3);

        TestableRandom.setNextInts(2);
        assertEquals(obj3, testerBag.pick());

        TestableRandom.setNextInts(1);
        assertEquals(obj2, testerBag.pick());
    }


    /**
     * Tests the remove method if the object trying to be removed is
     * not present in the bag.
     */
    public void testRemoveFalse() {
        testerBag.add(obj);
        testerBag.add(obj2);
        testerBag.add(obj3);

        Object notPresent = new Object();
        assertFalse(testerBag.remove(notPresent));
    }


    /**
     * Tests the remove method if the object trying to be removed is present
     * in the bag
     */
    public void testRemoveTrue() {
        testerBag.add(obj);
        testerBag.add(obj2);
        testerBag.add(obj3);
        assertEquals(3, testerBag.getCurrentSize());
        assertTrue(testerBag.remove(obj));
        assertEquals(2, testerBag.getCurrentSize());
    }
}
