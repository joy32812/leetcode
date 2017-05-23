package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyuan on 23/05/2017.
 */
public class P385_MiniParser {

    /*
    private int n;
    private int[] pair;
    public NestedInteger deserialize(String s) {
        if(s == null || s.isEmpty() || s.length() == 0) return new NestedInteger();

        n = s.length();
        pair = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
            } else if(s.charAt(i) == ']') {
                pair[stack.pop()] = i;
            }
        }

        return work(s, 0, n - 1);
    }

    private NestedInteger work(String s, int l, int r) {
        if (l > r) {return new NestedInteger();}

        if (s.charAt(l) == '[') {

            NestedInteger ans = new NestedInteger();
            int last = l + 1;
            for (int i = l + 1; i <= r; i++) {
                if (s.charAt(i) == ',' || i == r) {
                    if (last <= i - 1) {
                        ans.add(work(s, last, i - 1));
                    }
                    last = i + 1;
                } else if (s.charAt(i) == '[') {

                    ans.add(work(s, i, pair[i]));

                    last = pair[i] + 2;
                    i = pair[i] + 1;
                }
            }

            return ans;

        } else {
            int val = Integer.parseInt(s.substring(l, r + 1));
            return new NestedInteger(val);
        }
    }*/

}
