package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xiaoyuan on 25/05/2017.
 */
public class P394_DecodeString {

    int[] pair;
    public String decodeString(String s) {

        int n = s.length();
        pair = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') stack.push(i);
            else if (ch == ']') {
                pair[stack.peek()] = i;
                stack.pop();
            }
        }

        return dfs(s, 0, s.length() - 1);

    }


    private String dfs(String s, int l, int r) {
        StringBuilder sb = new StringBuilder();

        int number = 0;
        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);

            if (number == 0) {
                if (Character.isLetter(ch)) sb.append(ch);
                else if (Character.isDigit(ch)) number = number * 10 + (ch - '0');
            } else {
                if (Character.isDigit(ch)) number = number * 10 + (ch - '0');
                else if (ch == '[') {
                    String innerStr = dfs(s, i + 1, pair[i] - 1);
                    for (int j = 0; j < number; j++) sb.append(innerStr);

                    number = 0;
                    i = pair[i];
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P394_DecodeString().decodeString("13[acdsf]"));
        System.out.println(new P394_DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new P394_DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new P394_DecodeString().decodeString("2[abc]3[cd]ef"));
    }

}
