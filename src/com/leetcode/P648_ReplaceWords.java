package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 27/07/2017.
 */
public class P648_ReplaceWords {

    private class TNODE {
        boolean isWord;
        TNODE[] next;

        public TNODE() {
            this.next = new TNODE[26];
        }
    }

    public String replaceWords(List<String> dict, String sentence) {

        TNODE root = new TNODE();

        for (String s : dict) {
            Insert(root, s);
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(getPrefix(root, w));
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private String getPrefix(TNODE root, String w) {
        StringBuilder sb = new StringBuilder();
        for (char ch : w.toCharArray()) {
            sb.append(ch);
            if (root.next[ch - 'a'] == null) {return w;}
            if (root.next[ch - 'a'].isWord) {
                return sb.toString();
            }
            root = root.next[ch - 'a'];
        }
        return sb.toString();
    }

    private void Insert(TNODE root, String s) {

        for (char ch : s.toCharArray()) {
            if (root.next[ch - 'a'] == null) {
                root.next[ch - 'a'] = new TNODE();
            }
            root = root.next[ch - 'a'];
        }
        root.isWord = true;

    }

}
