package com.leetcode;

public class P1031_MaximumSumofTwoNonOverlappingSubarrays {


    /**
     * dp
     * slide window
     * 
     * @param A
     * @param L
     * @param M
     * @return
     */
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {

        int n = A.length;
        int[] sumL = new int[n];
        int[] sumM = new int[n];

        int totalL = 0;
        int totalM = 0;
        for (int i = 0; i < n; i++) {
            totalL += A[i];
            if (i >= L) totalL -= A[i - L];
            sumL[i] = totalL;

            totalM += A[i];
            if (i >= M) totalM -= A[i - M];
            sumM[i] = totalM;
        }


        int[] maxL = new int[n];
        int[] maxM = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            maxL[i] = Math.max(i + 1 < n ? maxL[i + 1] : 0, sumL[i]);
            maxM[i] = Math.max(i + 1 < n ? maxM[i + 1] : 0, sumM[i]);
        }


        int ans = 0;

        int leftL = 0;
        int leftM = 0;
        for (int i = 0; i < n; i++) {
            leftL = Math.max(leftL, sumL[i]);
            leftM = Math.max(leftM, sumM[i]);

            if (i + M < n) ans = Math.max(ans, leftL + maxM[i + M]);
            if (i + L < n) ans = Math.max(ans, leftM + maxL[i + L]);
        }

        return ans;
    }
    

    public static void main(String[] args) {

    }

}
