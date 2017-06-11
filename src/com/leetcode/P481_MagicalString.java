package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P481_MagicalString {

    public int magicalString(int n) {
        if (n <= 0) {return 0;}

        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);

        int lb = 2;
        while (A.size() < n) {
            int bb = A.get(lb);
            int add = 3 - A.get(A.size() - 1);

            while (bb > 0) {
                A.add(add);
                bb --;
            }
            lb++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (A.get(i) == 1) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P481_MagicalString().magicalString(4));
    }

}
