package com.leetcode;

/**
 * Created by xiaoyuan on 27/02/2017.
 *
 * Careful: negative n!!!
 *          & OverFlow!!!!
 */
public class P50_PowXY {

    public double myPow(double x, int n) {
        return pow(x, n);
    }

    public double pow(double x, long n) {
        if (n == 0) {
            return 1.0d;
        }

        boolean neg = false;
        if (n < 0) {
            neg = true;
            n = -n;
        }

        double res = pow(x, n / 2);

        double ans = res * res;
        if (n % 2 == 1) {
            ans *= x;
        }

        if (neg) {
            return 1.0 / ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P50_PowXY().myPow(2.0, -2147483648));
    }

}
