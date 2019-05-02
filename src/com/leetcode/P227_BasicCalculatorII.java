package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 07/04/2017.
 */
public class P227_BasicCalculatorII {

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        return compute(s.replaceAll(" ", ""));
    }

    private int compute(String s) {

        String[] ops = {"+", "-", "*/"};

        LinkedList<Character> mulDivList = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*' || ch == '/') mulDivList.add(ch);
        }


        for (String op : ops) {
            List<String> subList = parse(s, op);
            if (subList.size() > 1) {
                int ans = compute(subList.get(0));

                for (int i = 1; i < subList.size(); i++) {
                    int now = compute(subList.get(i));

                    if (op.equals("+")) {
                        ans += now;
                    } else if (op.equals("-")) {
                        ans -= now;
                    } else {
                        if (mulDivList.getFirst() == '*') ans *= now;
                        else ans /= now;

                        mulDivList.removeFirst();
                    }
                }

                return ans;
            }
        }

        return Integer.parseInt(s);
    }

    private List<String> parse(String s, String op) {
        String[] split = s.split("[" + op + "]");
        return new ArrayList<>(Arrays.asList(split));
    }

    public static void main(String[] args) {
        System.out.println(new P227_BasicCalculatorII().calculate("2*5/3"));
//        System.out.println(new P227_BasicCalculatorII().calculate("3 + 5 / 2"));
//        System.out.println(new P227_BasicCalculatorII().calculate("1+2*5/3+6/4*2"));
    }

}
