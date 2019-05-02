package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P842_SplitArrayintoFibonacciSequence {


    public List<Integer> splitIntoFibonacci(String S) {

        LinkedList<Integer> ans = new LinkedList<>();

        if (okay(S, 0, ans)) return ans;
        return new LinkedList<>();

    }

    private boolean okay(String s, int pos, LinkedList<Integer> ans) {
        if (pos == s.length()) {
            return ans.size() >= 3;
        }

        long now = 0;
        for (int i = pos; i < s.length(); i++) {
            if (i != pos && s.charAt(pos) == '0') break;
            now = now * 10 + (s.charAt(i) - '0');
            if (now >= Integer.MAX_VALUE) break;

            if (ans.size() < 2 || now == ans.getLast() + ans.get(ans.size() - 2)) {
                ans.addLast((int) now);
                if (okay(s, i + 1, ans)) return true;
                ans.removeLast();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P842_SplitArrayintoFibonacciSequence().splitIntoFibonacci("123456579"));
    }

}
