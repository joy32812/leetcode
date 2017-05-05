package com.leetcode;

/**
 * Created by xiaoyuan on 05/05/2017.
 */
public class P344_ReverseString {

    public String reverseString(String s) {

        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        System.out.println(new P344_ReverseString().reverseString("abcdefef"));
    }
}
