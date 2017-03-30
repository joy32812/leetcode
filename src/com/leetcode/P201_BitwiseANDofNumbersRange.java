package com.leetcode;

/**
 * Created by xiaoyuan on 29/03/2017.
 */
public class P201_BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int ans = 0;
        int sub = n - m;

        for (int i = 0; i < 32; i++) {
            if (sub >= (1 << i) + 1) {
                continue;
            } else {

                if ((m & (1 << i)) != 0 && (n & (1 << i)) != 0) {
                    ans = (1 << i);
                }
                int j = i + 1;
                for (; j < 32; j++) {
                    if ((m & (1 << j)) > 0 && (n & (1 << j)) > 0) {
                        ans += (1 << j);
                    }
                }
                break;
            }
        }

        return ans;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        return n > m ? (rangeBitwiseAnd(m / 2, n / 2) << 1) : m;
    }


    public static void main(String[] args) {
        System.out.println(new P201_BitwiseANDofNumbersRange().rangeBitwiseAnd(2, 2));
    }

}
