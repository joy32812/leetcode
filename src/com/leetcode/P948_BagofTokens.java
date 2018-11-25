package com.leetcode;

import java.util.Arrays;

public class P948_BagofTokens {


    /**
     * greedy
     * get all coins if you can
     * and exchange the one with the biggest power when you can't
     * @param tokens
     * @param P
     * @return
     */
    public int bagOfTokensScore(int[] tokens, int P) {
        int ans = 0;
        Arrays.sort(tokens);

        int l = 0;
        int r = tokens.length - 1;


        int coin = 0;
        int power = P;
        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l];
                coin ++;
                l ++;
                ans = Math.max(ans, coin);
            } else if (coin > 0) {
                coin --;

                power += tokens[r];
                r--;
            } else {
                break;
            }
        }


        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P948_BagofTokens().bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }
}
