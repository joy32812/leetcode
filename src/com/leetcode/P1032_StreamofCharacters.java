package com.leetcode;


/**
 * trie tree
 */
class StreamChecker {

    class TrieNode {
        boolean isWord;
        TrieNode[] next;

        public TrieNode() {
            this.isWord = false;
            this.next = new TrieNode[26];
        }
    }
    TrieNode root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        root = new TrieNode();

        for (String w: words) {
            buildTree(root, w);
        }

    }

    private void buildTree(TrieNode root, String w) {
        TrieNode now = root;
        for (int i = w.length() - 1; i >= 0; i--) {
            char ch = w.charAt(i);
            if (now.next[ch - 'a'] == null) now.next[ch - 'a'] = new TrieNode();
            now = now.next[ch - 'a'];
        }
        now.isWord = true;
    }

    public boolean query(char letter) {
        sb.append(letter);

        return find(sb.toString());
    }


    private boolean find(String s) {

        TrieNode now = root;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (now.next[ch - 'a'] == null) return false;

            now = now.next[ch - 'a'];
            if (now.isWord) return true;
        }

        return false;
    }

}

public class P1032_StreamofCharacters {

    

    public static void main(String[] args) {
        StreamChecker sc = new StreamChecker(new String[]{"cd", "f", "kl"});

        System.out.println(sc.query('a'));
        System.out.println(sc.query('b'));
        System.out.println(sc.query('c'));
        System.out.println(sc.query('d'));
        System.out.println(sc.query('e'));
        System.out.println(sc.query('f'));

    }

}
