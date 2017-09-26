package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 24/09/2017.
 */
public class P682_BaseballGame {

    public int calPoints(String[] ops) {

        Stack<Integer> Q = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                List<Integer> tmp = new ArrayList<>();
                while (!Q.isEmpty() && tmp.size() < 2) {
                    tmp.add(Q.pop());
                }

                int ans = 0;
                for (int i = tmp.size() - 1; i >= 0; i--) {
                    ans += tmp.get(i);
                    Q.add(tmp.get(i));
                }
                Q.add(ans);
            } else if (op.equals("D")) {
                int ans = 0;
                if (!Q.isEmpty()) {
                    ans = Q.peek() * 2;
                }

                Q.add(ans);
            } else if (op.equals("C")) {
                Q.pop();
            } else {
                int ans = Integer.parseInt(op);
                Q.add(ans);
            }
        }

        int ans = 0;
        while (!Q.isEmpty()) {
            ans += Q.pop();
        }

        return ans;
    }

}
