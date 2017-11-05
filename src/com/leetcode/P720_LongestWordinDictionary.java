package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by xiaoyuan on 05/11/2017.
 */
public class P720_LongestWordinDictionary {

    private class TrieNode {
        boolean isWord;
        TrieNode[] next;

        public TrieNode() {
            this.next = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    public String longestWord(String[] words) {

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        String ans = "";
        for (String w : words) {
            if (insert(root, w)) {
                if (ans.length() < w.length() || (ans.length() == w.length() && ans.compareTo(w) > 0)) {
                    ans = w;
                }
            }
        }

        return ans;
    }

    private boolean insert(TrieNode root, String w) {
        boolean res = true;

        TrieNode now = root;
        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(i);
            if (now.next[ch - 'a'] == null) {
                if (i != w.length() - 1) res = false;
                now.next[ch - 'a'] = new TrieNode();
            }

            now = now.next[ch - 'a'];
            if (i != w.length() - 1 && !now.isWord) res = false;
        }

        now.isWord = true;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P720_LongestWordinDictionary().longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(new P720_LongestWordinDictionary().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }


}
