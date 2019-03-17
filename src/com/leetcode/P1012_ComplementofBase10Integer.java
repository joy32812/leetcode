package com.leetcode;

public class P1012_ComplementofBase10Integer {


    /**
     * easy, to binary and convert to int
     * @param N
     * @return
     */
    public int bitwiseComplement(int N) {

        String s = Integer.toBinaryString(N);

        int ans = 0;
        for (char ch : s.toCharArray()) {
            ans = ans * 2 + (ch == '0' ? 1 : 0);
        }
        return ans;

    }


    public static void main(String[] args) {

        System.out.println(new P1012_ComplementofBase10Integer().bitwiseComplement(5));
        System.out.println(new P1012_ComplementofBase10Integer().bitwiseComplement(7));
        System.out.println(new P1012_ComplementofBase10Integer().bitwiseComplement(10));
    }

}
