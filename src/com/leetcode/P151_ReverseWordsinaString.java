package com.leetcode;

/**
 * Created by xiaoyuan on 21/03/2017.
 */
public class P151_ReverseWordsinaString {

    public String reverseWords(String s) {
        if (s == null) {return s;}
        StringBuilder sb = new StringBuilder();

        String[] splits = s.split(" ");
        for (int i = 0; i < splits.length; i++) {
            if (!splits[i].equals("")) {
                if (sb.length() > 0) {sb.append(" ");}
                sb.append(new StringBuilder(splits[i]).reverse());
            }
        }

        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new P151_ReverseWordsinaString().reverseWords("adde  bsd"));
        System.out.println(new P151_ReverseWordsinaString().reverseWords("   the sky    is    blue"));
    }
}
