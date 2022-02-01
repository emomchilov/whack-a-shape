package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This provides the SimpleArrayBag class.
 * 
 * @author meden97
 * @version 19.09.2018
 *
 * @param <T>
 *            object
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private int numberOfEntries;
    private static final int MAX = 25;
    private T[] bag;


    /**
     * This is the constructor for the SimpleArrayBag class.
     */
    public SimpleArrayBag() {
        numberOfEntries = 0;
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
    }


    /**
     * Adds an object to the bag.
     */
    @Override
    public boolean add(T anEntry) {
        if (numberOfEntries < 25 && anEntry != null) {
            bag[numberOfEntries] = anEntry;
            numberOfEntries++;
            return true;
        }
        return false;
    }


    /**
     * Gets the current size of the bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * Checks if the bag is empty.
     */
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    /**
     * Picks an object from the bag.
     */
    @Override
    public T pick() {
        if (isEmpty()) {
            return null;
        }
        else {
            TestableRandom generator = new TestableRandom();
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }
    }


    /**
     * A private helper method for the remove() method.
     */
    private int getIndexOf(T anEntry) {
        int noMatch = -1;
        for (int i = 0; i < this.getCurrentSize(); i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return noMatch;
    }


    /**
     * Removes an item from the bag.
     */
    @Override
    public boolean remove(T anEntry) {
        int entryIndex = this.getIndexOf(anEntry);
        if (entryIndex == -1) {
            return false;
        }
        else {
            bag[entryIndex] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
    }
}
