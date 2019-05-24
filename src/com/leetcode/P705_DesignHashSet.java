package com.leetcode;

public class P705_DesignHashSet {


    class MyHashSet {

        boolean[] A;

        /** Initialize your data structure here. */
        public MyHashSet() {
            A = new boolean[1000000 + 10];
        }

        public void add(int key) {
            A[key] = true;
        }

        public void remove(int key) {
            A[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return A[key];
        }
    }


}
