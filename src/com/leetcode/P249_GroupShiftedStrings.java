package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P249_GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String w : strings) {
            StringBuilder sb = new StringBuilder("#");
            for (int i = 1; i < w.length(); i++) {
                sb.append((26 + w.charAt(i) - w.charAt(i - 1)) % 26);
            }

            List<String> stringList = map.get(sb.toString());
            if (stringList == null) {stringList = new ArrayList<>();}
            stringList.add(w);
            map.put(sb.toString(), stringList);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }

}
