package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 27/02/2017.
 * simple map use
 */
public class P49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortS = new String(charArray);

            List<String> lists = map.get(sortS);
            if (lists == null) {
                lists = new ArrayList<String>();
            }

            lists.add(s);
            map.put(sortS, lists);
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (String key: map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(new P49_GroupAnagrams().groupAnagrams(strs));
    }

}
