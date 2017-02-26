package com.leetcode;

/**
 * Created by xiaoyuan on 26/02/2017.
 *
 * bigInteger Multiply
 */

public class P43_MultiplyStrings {

    public String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = num1.length() - 1, j = num2.length() - 1;; i--,j--) {
            if (i < 0 && j < 0) {
                break;
            }
            int a = 0;
            if (i >= 0) {
                a = Integer.parseInt("" + num1.charAt(i));
            }

            int b = 0;
            if (j >= 0) {
                b = Integer.parseInt("" + num2.charAt(j));
            }

            int total = a + b + carry;
            sb.append(total % 10);
            carry = total / 10;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public String multiplyOne(String num, int n, int pos) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int a = Integer.parseInt("" + num.charAt(i));
            int total = a * n + carry;
            sb.append(total % 10);
            carry = total / 10;
        }

        if (carry > 0) {
            sb.append(carry);
        }
        sb = sb.reverse();
        for (int i = 0; i < pos; i++) {
            sb.append("0");
        }

        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        String result = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {
            result = add(result, multiplyOne(num1, Integer.parseInt("" + num2.charAt(i)), num2.length() - i - 1));
        }

        int zeroPos = 0;
        if (result.charAt(0) == '0' && result.length() > 1) {
            while (zeroPos < result.length() - 1) {
                if (result.charAt(zeroPos) != '0') {
                    break;
                }
                zeroPos++;
            }

            result = result.substring(zeroPos);
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P43_MultiplyStrings().multiply("123456789", "987654321"));
    }

}
