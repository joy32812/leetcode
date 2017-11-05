package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 05/11/2017.
 */
public class P721_AccountsMerge {
    Map<Integer, Integer> fatherMap = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        fatherMap = new HashMap<>();
        Map<Integer, String> indexMap = new HashMap<>();
        Map<String, Integer> emailMap = new HashMap<>();
        int cnt = 0;
        for (List<String> user : accounts) {
            cnt++;

            String name=  user.get(0);
            int tmp = Integer.MAX_VALUE;
            for (int i = 1; i < user.size(); i++) {
                String email = user.get(i);
                if (emailMap.containsKey(email)) {
                    int v = findFather(emailMap.get(email));
                    if (tmp == Integer.MAX_VALUE) tmp = v;
                    else {
                        tmp = findFather(tmp);
                        int z = Math.min(tmp, v);
                        fatherMap.put(tmp, z);
                        fatherMap.put(v, z);
                    }
                }
            }

            if (tmp == Integer.MAX_VALUE) {
                tmp = cnt;
            }
            indexMap.put(tmp, name);
            for (int i = 1; i < user.size(); i++) {
                String email = user.get(i);
                emailMap.put(email, tmp);
            }
        }

        Map<Integer, List<String>> ansMap = new HashMap<>();
        for (String email : emailMap.keySet()) {
            int index = findFather(emailMap.get(email));
            List<String> list = ansMap.computeIfAbsent(index, k -> new ArrayList<String>());
            if (list.size() == 0) list.add(indexMap.get(index));
            list.add(email);
        }

        List<List<String>> res = new ArrayList<>();

        for (List<String> v : ansMap.values()) {
            Collections.sort(v);
            res.add(v);
        }

        return res;
    }

    private int findFather(int d) {

        while (true) {
            if (!fatherMap.containsKey(d)) {
                return d;
            }

            int v = fatherMap.get(d);
            if (v == d) return v;

            d = v;
        }
    }

    public static void main(String[] args) {

    }

}
