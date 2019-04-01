package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P990_SatisfiabilityofEqualityEquations {

    /**
     * easy
     * union find
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        Map<String, String> fatherMap = new HashMap<>();
        for (String eq : equations) {
            if (eq.charAt(1) == '!') continue;
            String s = "" + eq.charAt(0);
            String t = "" + eq.charAt(3);
            String fs = getFather(fatherMap, s);
            String ft = getFather(fatherMap, t);

            fatherMap.put(fs, ft);
        }


        for (String eq : equations) {
            if (eq.charAt(1) == '=') continue;

            String s = "" + eq.charAt(0);
            String t = "" + eq.charAt(3);
            String fs = getFather(fatherMap, s);
            String ft = getFather(fatherMap, t);

            if (fs.equals(ft)) return false;
        }


        return true;
    }

    private String getFather(Map<String, String> fatherMap, String s) {
        if (!fatherMap.containsKey(s)) fatherMap.put(s, s);

        String now = s;
        while (!now.equals(fatherMap.get(now))) {
            now = fatherMap.get(now);
        }

        fatherMap.put(s, now);
        return now;
    }

    public static void main(String[] args) {
        System.out.println(new P990_SatisfiabilityofEqualityEquations().equationsPossible(new String[]{
                "a==b",
                "b!=a"
        }));
    }

}
