package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by xiaoyuan on 13/11/2017.
 */
public class P726_NumberofAtoms {

    int ID;
    Map<String, Integer> nameMap;
    Map<Integer, String> backMap;
    public String countOfAtoms(String formula) {

        ID = 0;
        nameMap = new HashMap<>();
        backMap = new HashMap<>();
        Stack<int[]> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (sb.length() > 0) {
                    if (cnt == 0) cnt = 1;
                    int z = nameIndex(sb.toString());
                    stack.push(new int[]{z, cnt});


                    sb = new StringBuilder();
                    cnt = 0;
                }
                sb.append(ch);
            } else if (Character.isDigit(ch)) {
                cnt = cnt * 10 + (ch - '0');
            } else if (Character.isLowerCase(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                if (sb.length() > 0) {
                    if (cnt == 0) cnt = 1;
                    int z = nameIndex(sb.toString());
                    stack.push(new int[]{z, cnt});


                    sb = new StringBuilder();
                    cnt = 0;
                }
                stack.push(new int[]{-1, -1});
            } else if (ch == ')') {

                if (sb.length() > 0) {
                    if (cnt == 0) cnt = 1;
                    int z = nameIndex(sb.toString());
                    stack.push(new int[]{z, cnt});


                    sb = new StringBuilder();
                    cnt = 0;
                }

                int num = 0;
                int j = i + 1;
                for (; j < formula.length(); j++) {
                    char cj = formula.charAt(j);
                    if (!Character.isDigit(cj)) break;

                    num = num * 10 + (cj - '0');
                }
                if (num == 0) num = 1;

                i = j - 1;

                List<int[]> tmp = new ArrayList<>();
                while (!stack.isEmpty()) {
                    int[] now = stack.pop();
                    if (now[0] == -1) break;

                    tmp.add(new int[]{now[0], now[1] * num});
                }

                for (int[] now : tmp) {
                    stack.push(now);
                }
            }

        }

        if (sb.length() > 0) {
            if (cnt == 0) cnt = 1;
            int z = nameIndex(sb.toString());
            stack.push(new int[]{z, cnt});


            sb = new StringBuilder();
            cnt = 0;
        }


        Map<String, Integer> numMap = new TreeMap<>();
        while (!stack.isEmpty()) {
            int[] now = stack.pop();
            String ele = backMap.get(now[0]);

            numMap.put(ele, numMap.getOrDefault(ele, 0) + now[1]);
        }

        StringBuilder ans = new StringBuilder();
        for (String key : numMap.keySet()) {
            ans.append(key);
            if (numMap.get(key) > 1) ans.append(numMap.get(key));
        }

        return ans.toString();
    }

    private int nameIndex(String s) {
        if (nameMap.containsKey(s)) return nameMap.get(s);
        nameMap.put(s, ++ID);
        backMap.put(ID, s);

        return nameMap.get(s);
    }

}
