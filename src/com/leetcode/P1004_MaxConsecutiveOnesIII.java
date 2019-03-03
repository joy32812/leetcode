package com.leetcode;

public class P1004_MaxConsecutiveOnesIII {

    /**
     * much simpler solution
     * using slide window
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {

        int ans = 0;
        int i = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] == 0) K --;

            while (K < 0) {
                if (A[i++] == 0) K ++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return 0;
    }

    /**
     * prefix sum and binary search
     * not very elegant
     * @param A
     * @param K
     * @return
     */
    public int longestOnes2(int[] A, int K) {
        if (A == null || A.length == 0) return 0;


        int[] nums = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int last = i - 1 >= 0 ? nums[i - 1] : 0;

            if (A[i] == 0) last ++;
            nums[i] = last;
        }


        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            int z = nums[i] + K;
            if (A[i] == 0) z --;


            int l = i;
            int r = nums.length;
            while (l < r) {
                int m = (l + r) / 2;
                if (nums[m] <= z) l = m + 1;
                else r = m;
            }

//            l --;

            ans = Math.max(ans, l - i);

        }

        return ans;
    }


    public static void main(String[] args) {

        System.out.println(new P1004_MaxConsecutiveOnesIII().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(new P1004_MaxConsecutiveOnesIII().longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));

    }

}
