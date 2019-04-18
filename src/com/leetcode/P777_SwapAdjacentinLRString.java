package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P777_SwapAdjacentinLRString {

    /**
     * if X, not L before X
     * if L, not R before L
     * if R, not L or X before R
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {

        LinkedList<Integer> xList = new LinkedList<>();
        LinkedList<Integer> lList = new LinkedList<>();
        LinkedList<Integer> rList = new LinkedList<>();

        for (int i = 0; i < start.length(); i++) {
            char ch = start.charAt(i);
            if (ch == 'X') xList.add(i);
            else if (ch == 'L') lList.add(i);
            else rList.add(i);
        }

        for (char ch : end.toCharArray()) {
            if (ch == 'X') {
                if (xList.size() == 0) return false;
                if (lList.size() > 0 && lList.getFirst() < xList.getFirst()) return false;

                xList.removeFirst();
            } else if (ch == 'L') {
                if (lList.size() == 0) return false;
                if (rList.size() > 0 && rList.getFirst() < lList.getFirst()) return false;

                lList.removeFirst();
            } else {
                if (rList.size() == 0) return false;
                if (xList.size() > 0 && xList.getFirst() < rList.getFirst()) return false;
                if (lList.size() > 0 && lList.getFirst() < rList.getFirst()) return false;
                rList.removeFirst();
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new P777_SwapAdjacentinLRString().canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }

}
