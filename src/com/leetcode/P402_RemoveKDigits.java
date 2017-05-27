package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 28/05/2017.
 */
public class P402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder();

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';

            if (cnt == k) {
                if (stack.isEmpty()) {
                    int begin = num.length();
                    for (int j = i; j < num.length(); j++) {
                        if (num.charAt(j) != '0') {
                            begin = j;
                            break;
                        }
                    }

                    ans.append(num.substring(begin));
                    if (ans.length() == 0) {ans.append("0");}
                    return ans.toString();
                } else {
                    while (!stack.isEmpty()) {
                        ans.append(stack.pop());
                    }
                    ans = ans.reverse();
                    ans.append(num.substring(i));

                    return ans.toString();
                }
            }

            if (stack.isEmpty()) {
                if (d != 0) {stack.add(d);}
            } else {
                if (d >= stack.peek()) {
                    stack.add(d);
                } else {
                    while (!stack.isEmpty() && d < stack.peek() && cnt < k) {
                        cnt++;
                        stack.pop();
                    }
                    i--;
                }
            }

        }

        while (!stack.isEmpty() && cnt < k) {
            cnt ++;
            stack.pop();
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        ans = ans.reverse();


        if (ans.length() == 0) {ans.append("0");}
        return ans.toString();
    }


    public static void main(String[] args) {
        System.out.println(new P402_RemoveKDigits().removeKdigits("100", 1));
        System.out.println(new P402_RemoveKDigits().removeKdigits("10200", 1));
    }
}
