package com.leetcode;

import java.util.*;

public class P884_UncommonWordsfromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> cntMap = new HashMap<>();
        String[] ss = A.split(" ");
        String[] tt = B.split(" ");

        List<String> strList = new ArrayList<>(Arrays.asList(ss));
        strList.addAll(Arrays.asList(tt));

        for (String s : strList) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (String key : cntMap.keySet()) {
            if (cntMap.get(key) == 1) ans.add(key);
        }
        return ans.toArray(new String[ans.size()]);

    }

}
