package com.leetcode;


import java.util.LinkedList;

class RLEIterator {

    LinkedList<int[]> data;
    public RLEIterator(int[] A) {
        data = new LinkedList<>();
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] == 0) continue;;
            data.add(new int[]{A[i], A[i + 1]});
        }
    }

    public int next(int n) {
        if (data.isEmpty()) return -1;

        int ans = -1;
        while (n > 0 && !data.isEmpty()) {
            int[] first = data.getFirst();
            data.removeFirst();

            if (first[0] >= n) {
                ans = first[1];
                first[0] -= n;
                n = 0;
            } else {
                n -= first[0];
                first[0] = 0;
            }

            if (first[0] > 0) data.addFirst(first);
        }

        return ans;
    }
}
public class P900_RLEIterator {



}
