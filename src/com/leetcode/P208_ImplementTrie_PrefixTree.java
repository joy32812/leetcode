package com.leetcode;

/**
 * Created by xiaoyuan on 31/03/2017.
 */
public class P208_ImplementTrie_PrefixTree {

    private class TrieNode {
        char ch;
        boolean isWord;
        TrieNode[] nextNodes = new TrieNode[26];
        public TrieNode(char ch) {
            this.ch = ch;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public P208_ImplementTrie_PrefixTree() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char wCh = word.charAt(i);
            if (now.nextNodes[wCh - 'a'] == null) {
                now.nextNodes[wCh - 'a'] = new TrieNode(wCh);
            }
            now = now.nextNodes[wCh - 'a'];
        }
        now.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char wCh = word.charAt(i);
            if (now.nextNodes[wCh - 'a'] == null) {
                return false;
            }
            now = now.nextNodes[wCh - 'a'];
        }
        return now.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++) {
            char wCh = prefix.charAt(i);
            if (now.nextNodes[wCh - 'a'] == null) {
                return false;
            }
            now = now.nextNodes[wCh - 'a'];
        }
        return true;
    }

}
