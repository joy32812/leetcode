package com.leetcode;

public class P1007_MinimumDominoRotationsForEqualRow {


    /**
     * easy, try all the possible num for A and B
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations(int[] A, int[] B) {

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            ans = Math.min(ans, fix(A, B, i));
        }

        for (int i = 1; i <= 6; i++) {
            ans = Math.min(ans, fix(B, A, i));
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    private int fix(int[] a, int[] b, int k) {

        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                continue;
            }

            if (b[i] == k) {
                cnt ++;
                continue;
            }

            return Integer.MAX_VALUE;
        }

        return cnt;
    }


    public static void main(String[] args) {

        System.out.println(new P1007_MinimumDominoRotationsForEqualRow().minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }

}
