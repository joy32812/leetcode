package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 10/09/2017.
 */
public class P676_ImplementMagicDictionary {

    Set<String> set;
    /** Initialize your data structure here. */
    public P676_ImplementMagicDictionary() {
        set = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            sb = new StringBuilder(word);
            for (char ch = 'a'; ch <= 'z'; ch ++) {
                if (ch == word.charAt(i)) {continue;}

                sb.setCharAt(i, ch);

                if (set.contains(sb.toString())) {return true;}
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P676_ImplementMagicDictionary obj = new P676_ImplementMagicDictionary();
        obj.buildDict(new String[]{"hello"});

        System.out.println(obj.search("hhllo"));
    }

}
