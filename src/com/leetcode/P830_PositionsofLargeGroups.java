package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P830_PositionsofLargeGroups {

    /**
     * easy
     *
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();

        int from = -1;
        char now = '@';

        for (int i = 0; i < S.length(); i++) {
            if (now != S.charAt(i)) {
                if (from != -1 && i - from >= 3) ans.add(Arrays.asList(from, i - 1));

                from = i;
                now = S.charAt(i);
            }
        }

        if (from != -1 && S.length() - from >= 3) ans.add(Arrays.asList(from, S.length() - 1));

        return ans;
    }

}
