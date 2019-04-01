package com.leetcode;

public class P991_BrokenCalculator {

    /**
     * medium
     *
     * @param X
     * @param Y
     * @return
     */
    public int brokenCalc(int X, int Y) {
        if (X >= Y) return X - Y;

        int ans = 0;
        while (Y > X) {
            if (Y % 2 == 1) {
                Y++;
                ans++;
            }

            Y /= 2;
            ans ++;
        }


        return ans + (X - Y);
    }

    public static void main(String[] args) {
        System.out.println(new P991_BrokenCalculator().brokenCalc(2, 3));
        System.out.println(new P991_BrokenCalculator().brokenCalc(5, 8));
        System.out.println(new P991_BrokenCalculator().brokenCalc(3, 10));
        System.out.println(new P991_BrokenCalculator().brokenCalc(1024, 1));
    }

}
