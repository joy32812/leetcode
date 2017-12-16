package com.leetcode;

import java.util.HashMap;

/**
 * Created by xiaoyuan on 10/12/2017.
 */
public class P745_PrefixandSuffixSearch {

    HashMap<String, Integer> map = new HashMap<>();

    public P745_PrefixandSuffixSearch(String[] words) {

        for (int k = 0; k < words.length; k++) {
            String w = words[k];

            for (int i = 0; i <= w.length(); i++) {
                for (int j = 0; j <= w.length(); j++) {
                    String key = w.substring(0, i) + "#" + w.substring(w.length() - j);
                    map.put(key, k);
                }
            }
        }

    }


    public int f(String prefix, String suffix) {
        return map.containsKey(prefix + "#" + suffix) ? map.get(prefix + "#" + suffix) : -1;
    }


    public static void main(String[] args) {

        P745_PrefixandSuffixSearch obj = new P745_PrefixandSuffixSearch(new String[]{
                "apple"
        });

        System.out.println(obj.f("a", "e"));
        System.out.println(obj.f("b", ""));


    }

}
