package com.leetcode;

/**
 * Created by xiaoyuan on 17/05/2017.
 */
public class P371_SumofTwoIntegers {

    public int getSum(int a, int b) {

        int ans = 0;
        int last = 0;
        for (int i = 0; i < 32; i++) {

            boolean a1 = ((a & (1 << i)) != 0);
            boolean b1 = ((b & (1 << i)) != 0);

            if (last == 0 && a1 == false && b1 == false) {
                // 0
                last = 0;
            } else if (last == 0 && a1 == false && b1 == true) {
                // 1
                last = 0;
                ans |= (1 << i);
            } else if (last == 0 && a1 == true && b1 == false) {
                // 2
                last = 0;
                ans |= (1 << i);
            } else if (last == 0 && a1 == true && b1 == true) {
                // 3
                last = 1;
            } else if (last == 1 && a1 == false && b1 == false) {
                // 4
                last = 0;
                ans |= (1 << i);
            } else if (last == 1 && a1 == false && b1 == true) {
                // 5
                last = 1;
            } else if (last == 1 && a1 == true && b1 == false) {
                // 6
                last = 1;
            } else if (last == 1 && a1 == true && b1 == true) {
                // 7
                last = 1;
                ans |= (1 << i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P371_SumofTwoIntegers().getSum(5, 27));
    }

}
