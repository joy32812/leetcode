package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xiaoyuan on 15/09/2017.
 */
public class P472_ConcatenatedWords {

    class TrieNode {
        boolean isWord;
        TrieNode[] next;

        public TrieNode() {
            this.next = new TrieNode[26];
        }
    }


    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = buildTrie(words);

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if(okay(root, word, word)) {
                ans.add(word);
            }
        }

        return ans;
    }

    private boolean okay(TrieNode root, String word, String origin) {

        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (now.next[ch - 'a'] == null) {break;}
            now = now.next[ch - 'a'];
            if (!now.isWord) {continue;}

            if (i == word.length() - 1) {return !word.equals(origin);}

            if (okay(root, word.substring(i + 1), origin)) {return true;}
        }

        return false;
    }

    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode now = root;
            for (char ch : word.toCharArray()) {
                if (now.next[ch - 'a'] == null) {
                    now.next[ch - 'a'] = new TrieNode();
                }

                now = now.next[ch - 'a'];
            }
            now.isWord = true;
        }

        return root;
    }


    public static void main(String[] args) {

        System.out.println(new P472_ConcatenatedWords().findAllConcatenatedWordsInADict(new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));

    }

}
