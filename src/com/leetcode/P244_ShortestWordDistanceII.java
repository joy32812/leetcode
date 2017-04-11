package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 11/04/2017.
 */
public class P244_ShortestWordDistanceII {

    private Map<String, List<Integer>> posMap;
    private Map<String, Integer> ans;
    public P244_ShortestWordDistanceII(String[] words) {
        posMap = new HashMap<>();
        ans = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            List<Integer> list = posMap.get(w);
            if (list == null) {list = new ArrayList<>();}
            list.add(i);

            posMap.put(w, list);
        }
    }

    public int shortest(String w1, String w2) {
        String key = w1 + "#" + w2;
        if (w1.compareTo(w2) > 0) {
            key = w2 + "#" + w1;
        }

        if(ans.get(key) != null) {return ans.get(key);}

        List<Integer> l1 = posMap.get(w1);
        List<Integer> l2 = posMap.get(w2);

        int result = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while (a < l1.size() && b < l2.size()) {
            result = Math.min(result, Math.abs(l1.get(a) - l2.get(b)));

            if (l1.get(a) < l2.get(b)) {a++;}
            else {b++;}
        }

        ans.put(key, result);
        return result;
    }

}
