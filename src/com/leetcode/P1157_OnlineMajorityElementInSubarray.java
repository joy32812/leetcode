package com.leetcode;


import java.util.*;

public class P1157_OnlineMajorityElementInSubarray {

    class MajorityChecker {

        int[] A;
        Map<Integer, Integer> cntMap = new HashMap<>();

        TreeMap<Integer, Integer>[] setArr = new TreeMap[20002];
        public MajorityChecker(int[] arr) {
            A = arr;
            for (int i = 0; i < arr.length; i++) {
                int now = arr[i];
                if (setArr[now] == null) setArr[now] = new TreeMap<>();
                cntMap.put(now, cntMap.getOrDefault(now, 0) + 1);
                setArr[now].put(i, cntMap.get(now));
            }
        }

        public int query(int left, int right, int threshold) {
            for (int i = 0; i <= 30; i++) {
                int p = new Random().nextInt(right - left + 1) + left;
                int now = A[p];

//                int num = setArr[now].subSet(left, true, right, true).size();

                int rNum = 0;
                if (setArr[now].floorEntry(right) != null) rNum = setArr[now].floorEntry(right).getValue();
                int lNum = 0;
                if (setArr[now].floorEntry(left - 1) != null) lNum = setArr[now].floorEntry(left - 1).getValue();
                int num = rNum - lNum;

                if (num >= threshold) return now;
            }
            return -1;
        }
    }

    public static void main(String[] args) {

        new P1157_OnlineMajorityElementInSubarray().work();
    }

    private void work() {
        MajorityChecker mc = new MajorityChecker(new int[]{1, 1, 2, 2, 1, 1});
        mc.query(0, 5, 4);
    }

}
