package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P736_ParseLispExpression {

    public int evaluate(String expression) {

        Map<String, Stack<Integer>> values = new HashMap<>();

        Stack<String[]> stack = new Stack<>();

        // -100  (
        // 100 )
        // 0 let
        // 1 mul
        // 2 add
        // 3 number
        // 4 varible

        int now = -1;
        int op = -1;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                stack.push(new String[]{"-100", "" + op});
            } else if (Character.isLowerCase(ch)) {
                StringBuilder sb = new StringBuilder("" + ch);
                int j = i + 1;
                for (; j < expression.length(); j++) {
                    char th = expression.charAt(j);
                    if (th == ' ' || th == '(' || th == ')') break;
                    sb.append(th);
                }
                String ss = sb.toString();

                if (ss.equals("mult")) {
                    now = 1;
                    op = 1;
                    stack.push(new String[]{"" + now, sb.toString()});
                } else if (ss.equals("add")) {
                    now = 2;
                    op = 2;
                    stack.push(new String[]{"" + now, sb.toString()});
                } else if (ss.equals("let")) {
                    now = 0;
                    op = 0;
                    stack.push(new String[]{"" + now, sb.toString()});
                } else {
                    if (op == 0 && stack.peek()[0].equals("4")) {
                        now = 3;
                        int z = values.get(sb.toString()).peek();
                        values.computeIfAbsent(stack.peek()[1], k -> new Stack<Integer>()).push(z);
                        stack.push(new String[]{"" + now, "" + z});

                    } else {
                        now = 4;
                        stack.push(new String[]{"" + now, sb.toString()});
                    }

                }

                i = j - 1;
            } else if (Character.isDigit(ch) || ch == '+' || ch == '-') {
                StringBuilder sb = new StringBuilder("" + ch);
                int j = i + 1;
                for (; j < expression.length(); j++) {
                    char th = expression.charAt(j);
                    if (th == ' ' || th == '(' || th == ')') break;
                    sb.append(th);
                }
                if (now == 4 && op == 0) {
                    values.computeIfAbsent(stack.peek()[1], k -> new Stack<Integer>()).push(Integer.parseInt(sb.toString()));
                }
                stack.push(new String[]{"3", sb.toString()});

                i = j - 1;
            } else if (ch == ')') {
                if (op == 0) {
                    String[] tp = stack.pop();
                    if (tp[0].equals("4")) {
                        tp = new String[]{"3", "" + values.get(tp[1]).peek()};
                    }
                    while (!stack.isEmpty()) {
                        String[] v = stack.pop();
                        if (v[0].equals("3")) {
                            values.computeIfAbsent(stack.peek()[1], k -> new Stack<Integer>()).pop();
                        }

                        if (v[0].equals("-100")) {
                            op = Integer.parseInt(v[1]);
                            break;
                        };
                    }

                    stack.push(tp);

                } else if (op == 1) {

                    String[] aa = stack.pop();
                    String[] bb = stack.pop();
                    int xx = 0;
                    if (aa[0].equals("4")) {
                        xx = values.get(aa[1]).peek();
                    } else {
                        xx = Integer.parseInt(aa[1]);
                    }


                    int yy = 0;
                    if (bb[0].equals("4")) {
                        yy = values.get(bb[1]).peek();
                    } else {
                        yy = Integer.parseInt(bb[1]);
                    }

                    String[] res = new String[]{"3", "" + (xx * yy)};
                    String[] v = stack.pop();
                    if (v[0].equals("-100")) {
                        op = Integer.parseInt(v[1]);
                    };
                    v = stack.pop();
                    if (v[0].equals("-100")) {
                        op = Integer.parseInt(v[1]);
                    };

                    if (op == 0) {
                        values.computeIfAbsent(stack.peek()[1], k -> new Stack<Integer>()).push(Integer.parseInt(res[1]));
                    }
                    stack.push(res);


                } else if (op == 2) {
                    String[] aa = stack.pop();
                    String[] bb = stack.pop();
                    int xx = 0;
                    if (aa[0].equals("4")) {
                        xx = values.get(aa[1]).peek();
                    } else {
                        xx = Integer.parseInt(aa[1]);
                    }


                    int yy = 0;
                    if (bb[0].equals("4")) {
                        yy = values.get(bb[1]).peek();
                    } else {
                        yy = Integer.parseInt(bb[1]);
                    }

                    String[] res = new String[]{"3", "" + (xx + yy)};
                    String[] v = stack.pop();
                    if (v[0].equals("-100")) {
                        op = Integer.parseInt(v[1]);
                    };
                    v = stack.pop();
                    if (v[0].equals("-100")) {
                        op = Integer.parseInt(v[1]);
                    };

                    if (op == 0) {
                        values.computeIfAbsent(stack.peek()[1], k -> new Stack<Integer>()).push(Integer.parseInt(res[1]));
                    }
                    stack.push(res);
                }
            }
        }

        return Integer.parseInt(stack.peek()[1]);
    }

    public static void main(String[] args) {

//        System.out.println(new A4().evaluate("(add 1 2)"));
//        System.out.println(new A4().evaluate("(mult 3 (add 2 3))"));
//        System.out.println(new A4().evaluate("(let x 2 (mult x 5))"));
//        System.out.println(new A4().evaluate("(let x 2 x 2 x)"));
        System.out.println(new P736_ParseLispExpression().evaluate("(let x -2 y x y)"));
//        System.out.println(new A4().evaluate("(let a1 3 b2 (add a1 1) b2) "));
//        System.out.println(new A4().evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
//        System.out.println(new A4().evaluate("(let x 1 y 2 x (add x y) (add x y))"));
//        System.out.println(new A4().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));

    }

}
