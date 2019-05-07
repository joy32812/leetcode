package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P753_CrackingtheSafe {

    Set<String> seen;
    StringBuilder ans;
    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";

        seen = new HashSet<>();
        ans = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i ++) sb.append("0");


        dfs(sb.toString(), k);
        ans.append(sb.toString());

        return ans.toString();
    }

    private void dfs(String now, int k) {

        for (int i = 0; i < k; i++) {
            String t = now + i;
            if (seen.contains(t)) continue;
            seen.add(t);
            dfs(t.substring(1), k);
            ans.append(i);
        }

    }

    public static void main(String[] args) {
        System.out.println(new P753_CrackingtheSafe().crackSafe(2, 2));
    }

}
