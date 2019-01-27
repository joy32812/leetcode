package com.leetcode;

public class P984_StringWithoutAAAorBBB {

    public String strWithout3a3b(int A, int B) {

        /**
         * greedy algorithm
         * use the char with more number as possible
         */
        StringBuilder sb = new StringBuilder();
        while (A + B > 0) {
            if (A >= B) {
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'a' && sb.charAt(sb.length() - 2) == 'a') {
                    B --;
                    sb.append("b");
                } else {
                    A --;
                    sb.append("a");
                }
            } else {
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'b' && sb.charAt(sb.length() - 2) == 'b') {
                    A --;
                    sb.append("a");
                } else {
                    B --;
                    sb.append("b");
                }
            }
        }

        return sb.toString();
    }



    public static void main(String[] args) {

    }

}
