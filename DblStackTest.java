// File name: DblStackTest.java
// Author: Ashim Chand
// VUnetid: chanda
// Email: ashimchand@vanderbilt.edu
// Class: 3
// Assignment Number: 5
// Honor Statement: Will not use unfair means.
// Description: Testing of a stack of double values
// Last Changed: 3/19/2024

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DblStackTest {

    // TODO
    // Dear CS2201 student... at this point you should be comfortable creating JUnit
    // tests for the code that you write. Here is a starter file containing a single
    // simple test. Please enhance this test to be complete, and then create additional
    // tests to completely test the rest of the DblStack class.

    @Test
    public void testDefaultConstructor() {
        DblStack stk = new DblStack();
        assertEquals(0, stk.size());
    }

    @Test
    public void testPush() {
        DblStack stk = new DblStack();
        stk.push(22);
        stk.push(21);
        assertEquals(2, stk.size());
    }

    @Test
    public void testPop() {
        DblStack stk = new DblStack();
        assertThrows(RuntimeException.class, () -> stk.pop(), "empty stack");
        stk.push(22);
        stk.push(21);
        stk.pop();
        assertEquals(1, stk.size());
    }

    @Test
    public void testtop() {
        DblStack stk = new DblStack();
        assertThrows(RuntimeException.class, () -> stk.top(), "empty stack");
        stk.push(22);
        stk.push(21);
        assertEquals(21, stk.top());
    }

    @Test
    public void testsize() {
        DblStack stk = new DblStack();
        stk.push(22);
        stk.push(21);
        assertEquals(2, stk.size());
        stk.pop();
        assertEquals(1, stk.size());
    }

    @Test
    public void testclone() {
        DblStack stk = new DblStack();
        stk.push(22);
        stk.push(21);
        DblStack stkc = stk.clone();
        DblStack stk1 = new DblStack();
        assertTrue(stk.equals(stkc));
        assertFalse(stk.equals(stk1));
    }

    @Test
    public void testequals() {
        DblStack stk = new DblStack();
        stk.push(22);
        stk.push(21);
        DblStack stkc = stk.clone();
        DblStack stk1 = new DblStack();
        stk1.push(22);
        stk1.push(21);
        assertTrue(stk.equals(stkc));
        assertTrue(stk.equals(stk1));
    }

}
