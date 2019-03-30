package com.leetcode;

public class P927_ThreeEqualParts {

    /**
     * medium
     * divide three parts by ones
     * the count 0 by the last part
     * @param A
     * @return
     */
    public int[] threeEqualParts(int[] A) {
        int n = A.length;

        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            sums[i] = (i - 1 >= 0 ? sums[i - 1] : 0) + A[i];
        }

        int[] ans = new int[]{-1, -1};
        if (sums[n - 1] % 3 != 0) return ans;

        // this is important!!!
        if (sums[n - 1] == 0) return new int[]{0,2};

        int part = sums[n - 1] / 3;

        int s = -1;
        int t = -1;
        int z = -1;

        for (int i = 0; i < n; i++) {
            if (s == -1 && sums[i] == 1) s = i;
            if (t == -1 && sums[i] == part + 1) t = i;
            if (z == -1 && sums[i] == 2 * part + 1) z = i;
        }

        int cnt = 0;
        while (true) {
            if (A[s] != A[t] || A[s] != A[z]) return ans;
            if (A[s] == 1) cnt ++;

            s ++;
            t ++;
            z ++;
            if (cnt == part) break;
        }

        for (; z < n; z++) {
            if (A[s] == 1 || A[t] == 1) return ans;
            s++;
            t++;
        }

        return new int[]{s - 1, t};
    }

    public static void main(String[] args) {
        System.out.println(new P927_ThreeEqualParts().threeEqualParts(new int[]{0, 0, 0, 0, 0}));
        System.out.println(new P927_ThreeEqualParts().threeEqualParts(new int[]{1, 0, 1, 0, 1}));
        System.out.println(new P927_ThreeEqualParts().threeEqualParts(new int[]{1, 1, 0, 1, 1}));
    }

}
