package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 15/03/2017.
 *
 * just find all the palindrome at current pos
 */
public class P131_PalindromePartitioning {

    private List<List<Integer>> paPosList;
    private int n;
    private String oldS;

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s.length() == 0) {return result;}


        oldS = s;
        n = s.length();
        paPosList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            paPosList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n;i++) {
            int l = i, r = i;
            while (l >=0 && r < n && s.charAt(l) == s.charAt(r)) {
                paPosList.get(l).add(r);
                l--;
                r++;
            }

            l = i - 1;
            r = i;
            while (l >=0 && r < n && s.charAt(l) == s.charAt(r)) {
                paPosList.get(l).add(r);
                l--;
                r++;
            }
        }

        LinkedList<Integer> nextPos = new LinkedList<Integer>();
        dfs(0, nextPos, result);


        return result;
    }

    private void dfs(int i, LinkedList<Integer> nextPos, List<List<String>> result) {
        if (i == n) {
            List<String> tmp = new ArrayList<String>();
            int from = 0;
            for (int next : nextPos) {
                tmp.add(oldS.substring(from, next + 1));
                from = next + 1;
            }

            result.add(tmp);
            return;
        }

        List<Integer> paList = paPosList.get(i);
        for (int next: paList) {
            nextPos.add(next);
            dfs(next + 1, nextPos, result);
            nextPos.removeLast();
        }
    }
}
