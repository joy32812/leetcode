package com.leetcode;

public class P771_JewelsandStones {

    public int numJewelsInStones(String J, String S) {

        int ans = 0;
        for (char ch : S.toCharArray()) {
            if (J.indexOf(ch) !=-1) ans ++;
        }
        return ans;
    }

}
