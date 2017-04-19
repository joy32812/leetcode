package com.leetcode;

import java.util.Iterator;

/**
 * Created by xiaoyuan on 19/04/2017.
 */

public class P284_PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private boolean peek;
    private int peekValue;

    public P284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        peek = false;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek) {
            return peekValue;
        }
        peekValue = iter.next();
        peek = true;

        return peekValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek) {
            peek = false;
            return peekValue;
        } else {
            return iter.next();
        }
    }

    @Override
    public boolean hasNext() {
        return peek || iter.hasNext();
    }

}
