package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 21/09/2017.
 */
public class P527_WordAbbreviation {

    class TheTrieNode {
        Set<String> words;
        TheTrieNode[] next;

        public TheTrieNode() {
            this.words = new HashSet<>();
            this.next = new TheTrieNode[26];
        }
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> ans = new ArrayList<>();

        Map<String, TreeSet<String>> setMap = new HashMap<>();

        for (String word : dict) {
            String key = "" + word.charAt(0) + "_" + word.charAt(word.length() - 1) + "_" + word.length();
            setMap.computeIfAbsent(key, k -> new TreeSet<String>()).add(word);
        }

        Map<String, String> ansMap = new HashMap<>();
        for (String key : setMap.keySet()) {
            TreeSet<String> set = setMap.get(key);

            if (set.size() == 1) {
                String word = set.first();
                String abbr = "" + word.charAt(0) + (word.length() - 2 > 0 ? word.length() - 2 : "") + word.charAt(word.length() - 1);
                if (word.length() <= abbr.length()) {
                    abbr = word;
                }
                ansMap.put(word, abbr);
            } else {
                TheTrieNode root = new TheTrieNode();
                for (String word : set) {
                    build(root, word);
                }

                for (String word : set) {
                    count(root, word, ansMap);
                }
            }
        }

        for (String word : dict) {
            ans.add(ansMap.get(word));
        }

        return ans;
    }

    private void count(TheTrieNode root, String word, Map<String, String> ansMap) {
        TheTrieNode now = root;
        StringBuilder sb = new StringBuilder("" + word.charAt(0));
        for (int i = 1; i < word.length() - 1; i++) {
            char ch = word.charAt(i);
            sb.append(ch);
            now = now.next[ch - 'a'];

            if (now.words.size() == 1) {
                int num = word.length() - sb.length() - 1;
                if (num > 0) sb.append(num);
                sb.append(word.charAt(word.length() - 1));

                String abbr = sb.toString();
                if (abbr.length() >= word.length()) {
                    abbr = word;
                }

                ansMap.put(word, abbr);
                return;
            }
        }
    }

    private void build(TheTrieNode root, String word) {
        TheTrieNode now = root;
        for (int i = 1; i < word.length() - 1; i++) {
            char ch = word.charAt(i);
            if (now.next[ch - 'a'] == null) {
                now.next[ch - 'a'] = new TheTrieNode();
            }
            now.next[ch - 'a'].words.add(word);
            now = now.next[ch - 'a'];
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("like");
        list.add("god");
        list.add("internal");
        list.add("me");
        list.add("internet");
        list.add("interval");
        list.add("intension");
        list.add("face");
        list.add("intrusion");

        System.out.println(new Date().getTime());
        System.out.println(new P527_WordAbbreviation().wordsAbbreviation(list));
        System.out.println(new Date().getTime());
    }

}
