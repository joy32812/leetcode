package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 11/05/2017.
 */
public class P336_PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words == null || words.length < 2) {return ans;}

        Map<String, Integer> posMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {posMap.put(words[i], i);}

        Set<String> uniqSet = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];

            for (int j = 0; j <= w.length(); j++) {
                String start = w.substring(0, j);
                String end = w.substring(j);

                // head
                if (isPalindrome(end)) {
                    String other = new StringBuilder(start).reverse().toString();
                    if (posMap.containsKey(other) && posMap.get(other) != i) {
                        uniqSet.add(i + "_" + posMap.get(other));
                    }
                }


                // tail
                if (isPalindrome(start)) {
                    String other = new StringBuilder(end).reverse().toString();
                    if (posMap.containsKey(other) && posMap.get(other) != i) {
                        uniqSet.add(posMap.get(other) + "_" + i);
                    }
                }
            }
        }

        for (String s : uniqSet) {
            String[] arr = s.split("_");

            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(arr[0]));
            list.add(Integer.parseInt(arr[1]));

            ans.add(list);
        }

        return ans;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {return false;}
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P336_PalindromePairs().palindromePairs(new String[]{
                "abcd","dcba","lls","s","sssll"
        }));
    }

}
