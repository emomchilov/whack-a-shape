package game;

import bag.SimpleBagInterface;
import student.TestableRandom;
import bag.Node;

/**
 * This provides the SimpleArrayBag class.
 * 
 * @author meden97
 * @version 19.09.2018
 *
 * @param <T>
 *            object
 */

public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;


    /**
     * The constructor for the SimpleLinkedBag.
     */
    public SimpleLinkedBag() {

        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * Adds an object to the bag.
     */
    @Override
    public boolean add(T anEntry) {
        if (anEntry != null) {
            Node<T> newNode = new Node<T>(anEntry);
            newNode.setNext(firstNode);
            firstNode = newNode;
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
            Node<T> currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next();
            }
            return currentNode.data();
        }
    }


    /**
     * Removes an item from the bag.
     */
    @Override
    public boolean remove(T node) {
        boolean result = false;
        Node<T> aNode = getReferenceTo(node);

        if (aNode != null) {
            aNode.setData(firstNode.data());
            firstNode = firstNode.next();
            numberOfEntries--;
            result = true;
        }
        return result;
    }


    /**
     * Provides a private helper method for the remove method.
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;
        Node<T> currentNode = firstNode;

        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }
        return currentNode;
    }

}
