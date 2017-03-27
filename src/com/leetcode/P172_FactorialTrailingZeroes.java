package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 27/03/2017.
 */
public class P172_FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int a = 1;
        int ans = 0;
        while (n > 0) {
            ans += (n/5) * (a);
            n /= 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P172_FactorialTrailingZeroes().trailingZeroes(25));
        System.out.println(new P172_FactorialTrailingZeroes().trailingZeroes(100));
        System.out.println(new P172_FactorialTrailingZeroes().trailingZeroes(125));
        System.out.println(new P172_FactorialTrailingZeroes().trailingZeroes(2147483647));//536870902
    }

}
