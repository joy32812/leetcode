package com.leetcode;

import javax.sql.rowset.FilteredRowSet;
import java.util.Arrays;

public class P899_OrderlyQueue {

    /**
     * prove that if K >= 2, we can get any permutation we want
     * @param S
     * @param K
     * @return
     */
    public String orderlyQueue(String S, int K) {
        if (K >= 2) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        String ans = S;
        for (int i = 0; i < S.length(); i++) {
            String now = S.substring(i) + S.substring(0, i);
            if (ans.compareTo(now) > 0) ans = now;
        }

        return ans;
    }

}
