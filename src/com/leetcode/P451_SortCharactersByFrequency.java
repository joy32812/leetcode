package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P451_SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (!cntMap.containsKey(ch)) {cntMap.put(ch, 0);}
            cntMap.put(ch, cntMap.get(ch) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (char ch : cntMap.keySet()) {
            list.add(new int[]{cntMap.get(ch), (int)ch});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int[] nod : list) {
            for (int i = 0; i < nod[0]; i++){sb.append((char)nod[1]);}
        }
        return sb.toString();
    }

}
