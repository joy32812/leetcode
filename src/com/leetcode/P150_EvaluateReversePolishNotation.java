package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 21/03/2017.
 */
public class P150_EvaluateReversePolishNotation {


    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String tok : tokens) {
            if (!(tok.equals("+") || tok.equals("-") || tok.equals("*") || tok.equals("/"))) {
                stack.push(tok);
            } else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(calculate(tok, a, b));
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private String calculate(String tok, String a, String b) {
        int aa = Integer.valueOf(a);
        int bb = Integer.valueOf(b);

        if (tok.equals("+")) {
            return "" + (aa + bb);
        } else if (tok.equals("-")) {
            return "" + (aa - bb);
        } else if (tok.equals("*")) {
            return "" + (aa * bb);
        } else if (tok.equals("/")) {
            return "" + (aa / bb);
        }

        return "0";
    }

    public static void main(String[] args) {
        System.out.println(new P150_EvaluateReversePolishNotation().evalRPN(new String[]{"3", "-4", "+"}));
    }

}
