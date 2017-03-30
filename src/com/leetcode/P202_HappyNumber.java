package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 30/03/2017.
 */
public class P202_HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (!set.contains(n)) {
            set.add(n);
            int m = 0;
            while (n > 0) {
                int b = n % 10;
                n /= 10;
                m += (b * b);
            }

            if (m == 1) {return true;}
            n = m;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P202_HappyNumber().isHappy(19));
        System.out.println(new P202_HappyNumber().isHappy(Integer.MAX_VALUE));
    }

}
