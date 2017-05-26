package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 26/05/2017.
 */
public class P399_EvaluateDivision {

    private class Father {
        String var;
        double times;

        public Father(String var, double times) {
            this.var = var;
            this.times = times;
        }
    }

    private Map<String, Father> fatherMap;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        fatherMap = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            double val = values[i];

            Father fa = getFather(eq[0]);
            Father fb = getFather(eq[1]);


            fatherMap.put(fa.var, new Father(fb.var, val * fb.times / fa.times));
        }

        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            String A = query[0];
            String B = query[1];

            if (!fatherMap.containsKey(A) || !fatherMap.containsKey(B)) {
                ans[i] = -1.0;
                continue;
            }

            Father fa = getFather(A);
            Father fb = getFather(B);
            if (!fa.var.equals(fb.var)) {
                ans[i] = -1.0;
                continue;

            }

            ans[i] = fa.times / fb.times;
        }

        return ans;
    }

    private Father getFather(String s) {

        if (!fatherMap.containsKey(s)) {
            fatherMap.put(s, new Father(s, 1.0));
        }

        Father father = fatherMap.get(s);
        String nowStr = s;
        double nowRat = 1.0;
        while (!nowStr.equals(father.var)) {

            nowStr = father.var;
            nowRat = nowRat * father.times;
            father = fatherMap.get(nowStr);
        }

        fatherMap.put(s, new Father(nowStr, nowRat));

        return fatherMap.get(s);
    }

    public static void main(String[] args) {
        System.out.println(new P399_EvaluateDivision().calcEquation(
                new String[][]{
                        {"a", "b"},
                        {"b", "c"}
                },
                new double[]{
                        2.0, 3.0
                },
                new String[][]{
                        {"a", "c"},
                        {"b", "c"},
                        {"a", "e"},
                        {"a", "a"},
                        {"x", "x"},
                }
        ));
    }

}
