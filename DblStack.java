// File name: DblStack.java
// Author: Ashim Chand
// VUnetid: chanda
// Email: ashimchand@vanderbilt.edu
// Class: 3
// Assignment Number: 5
// Honor Statement: Will not use unfair means.
// Description: A stack of double values
// Last Changed: 3/19/2024

public class DblStack {

    // TODO
    // it is your job to define the private portion of the DblStack class here
    public static class Node {
        double data;
        Node next;

        public Node () {
            this(0, null);
        }

        Node(double data) {
            this.data = data;
            this.next = null;
        }

        public Node (double data, Node next) {
            this.data = data;
            this.next = next;
        }


    }
    private Node top;

    private int sizeS;



    // TODO
    // now that you have completed the private section, please complete these public methods
    // that define the public interface of the DblStack. Do not change any of the method
    // headers.


    /**
     * Default Constructor -- Create an empty stack.
     */
    public DblStack() {
        this.top = null;
    }

    /**
     *  isEmpty
     *  Checks if the stack is empty
     *  pre:  A stack exists.
     *  post: Returns true if it IS empty, false if NOT empty.
     */
    public boolean isEmpty() {
        return top == null;
    }


    /**
     *  push
     *  Pushes an item on top of the stack.
     *  pre:  Stack exists and item is passed.
     *  post: the item is placed on top of the stack, and size is incremented.
     */
    public void push(double item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        sizeS++;
    }


    /**
     * pop
     * Pops the top item off the stack.
     * pre:  Stack exists.
     * post: Removes item on top of stack.  If the stack
     *       was already empty, throws a RuntimeException exception.
     */
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        top = top.next;
        sizeS--;
    }


    /**
     *  top
     *  Returns the top item of the stack without popping it.
     *  pre:  Stack exists.
     *  post: Returns item on top of stack.  If the stack
     *        was already empty, throws a RuntimeException exception.
     */
    public double top() {
        if (isEmpty()) {
            throw new RuntimeException("empty stack");
        }
        return top.data;
    }


    /**
     *  size
     *  Returns the number of items on the stack.
     *  post: Returns size from the private section of class.
     */
    public int size() {
        return sizeS;
    }


    /**
     * clone
     * Return a new DblStack object that is a clone of the 'this' object.
     * The clone should have its own list (of the same size) and contain all the values
     * of 'this' object.
     */
    public DblStack clone() {
        DblStack copy = new DblStack();

        Node current = top;

        Node newy = new Node();
        newy.data = current.data;
        copy.top = newy;
        current = current.next;
        copy.sizeS = this.sizeS;

        while(current != null){
            newy.next = new Node();
            newy = newy.next;
            newy.data = current.data;
            current = current.next;
        }
        return copy;

    }


    /**
     * equals
     * Determine if two DblStack objects are equal
     * @param other -- The object to compare
     * @return true if the two DblStacks are equivalent (same size and same data)
     */
    @Override
    public boolean equals(Object other) {

        if (!(other instanceof DblStack)) return false;
        DblStack that = (DblStack) other;
        if (this.sizeS != that.sizeS) {
            return false;
        }
        Node thisCurrent = this.top, thatCurrent = that.top;
        while (thisCurrent != null && thatCurrent != null) {
            if (thisCurrent.data != thatCurrent.data) {
                return false;
            }
            thisCurrent = thisCurrent.next;
            thatCurrent = thatCurrent.next;
        }
        return thisCurrent == null && thatCurrent == null;
    }

}
