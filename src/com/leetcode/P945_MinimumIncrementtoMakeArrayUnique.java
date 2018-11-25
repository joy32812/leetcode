package com.leetcode;

import java.util.*;

public class P945_MinimumIncrementtoMakeArrayUnique {


    /**
     * much more simple solution
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        int ans = 0;
        Arrays.sort(A);

        int pre = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > pre) {
                pre = A[i] + 1;
                continue;
            }

            ans += pre - A[i];
            pre++;
        }

        return ans;
    }

    /**
     * find the nearest number that hasn't been used
     * not very straight-forward
     * @param A
     * @return
     */
    public int minIncrementForUnique2(int[] A) {

        boolean[] nums = new boolean[80000 + 10];


        Map<Integer, Integer> cntMap = new TreeMap<>();

        for (int i = 0; i < A.length; i++) {
            cntMap.put(A[i], cntMap.computeIfAbsent(A[i], k -> 0) + 1);

            nums[A[i]] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == false) q.add(i);
        }

        int ans = 0;
        for (int k : cntMap.keySet()) {
            int v = cntMap.get(k) - 1;

            for (int j = 0; j < v; j++) {
                while (!q.isEmpty() && q.peek() < k) q.poll();

                ans += q.peek() - k;
                q.poll();
            }
        }

        return ans;
    }




    public static void main(String[] args) {

//        System.out.println(new AA4().minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(new P945_MinimumIncrementtoMakeArrayUnique().minIncrementForUnique(new int[]{

                1, 2, 2

        }));

    }

}
