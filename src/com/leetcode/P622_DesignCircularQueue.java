package com.leetcode;

public class P622_DesignCircularQueue {

    class MyCircularQueue {

        int capacity;
        int[] data;

        int len;
        int beg;
        int end;



        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            capacity = k;
            data = new int[capacity];

            beg = 0;
            end = -1;
            len = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) return false;

            end = (end + 1) % capacity;
            data[end] = value;

            len ++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) return false;

            len --;
            beg = (beg + 1) % capacity;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return isEmpty() ? -1 : data[beg];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return isEmpty() ? -1 : data[end];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return len == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return len == capacity;
        }
    }


}
