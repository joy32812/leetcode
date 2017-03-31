package com.leetcode;

/**
 * Created by xiaoyuan on 31/03/2017.
 */
public class P211_AddandSearchWordDatastructuredesign {

    private class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] nextNodes = new TrieNode[26];

        public TrieNode(char val) {
            this.val = val;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public P211_AddandSearchWordDatastructuredesign() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length();i++) {
            char wch = word.charAt(i);
            if (now.nextNodes[wch - 'a'] == null) {now.nextNodes[wch - 'a'] = new TrieNode(wch);}
            now = now.nextNodes[wch - 'a'];
        }
        now.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return query(root, word, 0);
    }

    private boolean query(TrieNode root, String word, int begin) {
        if (begin == word.length() && root.isWord) {return true;}
        if (begin == word.length()) {return false;}

        char wch = word.charAt(begin);
        if (wch == '.') {
            for (int j = 0; j < 26; j++) {
                if (root.nextNodes[j] != null) {
                    if (query(root.nextNodes[j], word, begin + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (root.nextNodes[wch - 'a'] == null) {return false;}
            return query(root.nextNodes[wch - 'a'], word, begin + 1);
        }

    }


}
