package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xiaoyuan on 25/05/2017.
 */
public class P394_DecodeString {

    private Map<Integer, Integer> pairMap;
    public String decodeString(String s) {
        pairMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack.add(i);
            } else if (ch == ']') {
                pairMap.put(stack.pop(), i);
            }
        }

        return work(s, 0, s.length() - 1);
    }

    private String work(String s, int l, int r) {
        StringBuilder sb = new StringBuilder();

        int tmp = 0;

        for (int i = l; i <= r; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                tmp = tmp * 10 + ch - '0';
            } else if (ch == '[') {
                String subStr = work(s, i + 1, pairMap.get(i) - 1);
                for (int j = 1; j <= tmp; j++) {sb.append(subStr);}

                tmp = 0;
                i = pairMap.get(i);
            } else {
                sb.append(ch);
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
