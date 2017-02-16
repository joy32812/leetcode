package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 16/02/2017.
 */
public class P22_GenerateParentheses {

    private List<String> dfs(int ll, int rr) {
        List<String> result = new ArrayList<String>();

        if (ll == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rr; i++) {
                sb.append(")");
            }
            result.add(sb.toString());
            return result;
        }

        List<String> nextResult = dfs(ll - 1, rr);
        for (int i = 0; i < nextResult.size(); i++) {
            result.add("(" + nextResult.get(i));
        }

        if (ll < rr) {
            nextResult = dfs(ll, rr - 1);
            for (int i = 0; i < nextResult.size(); i++) {
                result.add(")" + nextResult.get(i));
            }
        }

        return result;
    }

    public List<String> generateParenthesis(int n) {
        return dfs(n, n);
    }

    public static void main(String[] args) {
        System.out.println(new P22_GenerateParentheses().generateParenthesis(3));
    }
}
