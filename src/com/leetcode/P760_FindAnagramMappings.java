package com.leetcode;

public class P760_FindAnagramMappings {

    public int[] anagramMappings(int[] A, int[] B) {

        int n = A.length;
        boolean[] visit =  new boolean[n];

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[j]) continue;

                if (A[i] == B[j]) {
                    visit[j] = true;
                    ans[i] = j;
                    break;
                }
            }
        }

        return ans;

    }

}
