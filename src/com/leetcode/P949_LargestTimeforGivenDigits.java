package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P949_LargestTimeforGivenDigits {

    /**
     * brute force
     * @param A
     * @return
     */
    public String largestTimeFromDigits(int[] A) {

        Set<String> allComSet = dfs(A);

        String ans = "";
        for (String s : allComSet) {
            if (okay(s) && bigger(s, ans)) ans = s;
        }

        if (ans.length() > 0) return ans.substring(0, 2) + ":" + ans.substring(2);
        return ans;
    }

    private boolean okay(String s) {
        int aa = Integer.parseInt(s.substring(0, 2));
        int bb = Integer.parseInt(s.substring(2));
        return aa >= 0 && aa < 24 && bb >= 0 && bb < 60;
    }

    private boolean bigger(String s, String ans) {
        return s.compareTo(ans) > 0;
    }

    private Set<String> dfs(int[] A) {

        Set<String> ans = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int z = 0; z < 4; z ++) {
                        if (i == j || i == k || i == z || j == k || j == z || k == z) continue;
                        ans.add(A[i] + "" + A[j] + "" + A[k] + "" + A[z]);
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P949_LargestTimeforGivenDigits().largestTimeFromDigits(new int[]{2, 0, 6, 6}));
    }

}
