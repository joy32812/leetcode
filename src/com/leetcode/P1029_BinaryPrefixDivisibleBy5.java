package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1029_BinaryPrefixDivisibleBy5 {


    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> ans = new ArrayList<>();

        int now = 0;
        for (int d : A) {
            now = now * 2 + d;
            if (now % 5 == 0) ans.add(true);
            else ans.add(false);

            now %= 5;
        }

        return ans;
    }


    public static void main(String[] args) {

    }

}
