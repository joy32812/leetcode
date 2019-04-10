package com.leetcode;

public class P917_ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int j = S.length() - 1; j >= 0 || cnt < S.length(); j--) {
            while (cnt < S.length() && !Character.isLetter(S.charAt(cnt))) {
                sb.append(S.charAt(cnt));
                cnt++;
            }

            if (j >= 0 && !Character.isLetter(S.charAt(j))) continue;

            if (j >= 0) {
                sb.append(S.charAt(j));
                cnt++;
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P917_ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(new P917_ReverseOnlyLetters().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

}
