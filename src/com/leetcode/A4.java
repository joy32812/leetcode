package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 10/12/2017.
 */
public class A4 {

    private class TNode {

        List<Integer> wordIndex;
        TNode[] next;

        public TNode() {
            this.wordIndex = new ArrayList<>();
            this.next = new TNode[30 * 30];
        }
    }

    private TNode root;

    public A4(String[] words) {

        root = new TNode();

        for (int i = 0; i < words.length; i++) {

            AddToTrie(root, words[i], i, 0, words[i].length() - 1);

        }

    }

    private void AddToTrie(TNode root, String word, int w, int l, int r) {
        if (l > r) return;
        if (l >= word.length()) return;
        if (r < 0) return;

        TNode now = root;
        now.wordIndex.add(w);

        char lch = word.charAt(l);
        char rch = word.charAt(r);

        int pos = 0;

        pos = 0 * 27 + (rch - 'a' + 1);
        if (now.next[pos] == null) {
            now.next[pos] = new TNode();
        }
        AddToTrie(now.next[pos], word, w, l, r - 1);


        pos = (lch - 'a' + 1) * 27 + 0;
        if (now.next[pos] == null) {
            now.next[pos] = new TNode();
        }
        AddToTrie(now.next[pos], word, w, l + 1, r);

        pos = (lch - 'a' + 1) * 27 + (rch - 'a' + 1);
        if (now.next[pos] == null) {
            now.next[pos] = new TNode();
        }
        AddToTrie(now.next[pos], word, w, l + 1, r - 1);
    }




    public int f(String prefix, String suffix) {

        TNode now = root;

        while (prefix.length() > 0 || suffix.length() > 0) {

            int a = prefix.length() == 0 ? 0 : (prefix.charAt(0) - 'a' + 1);
            int b = suffix.length() == 0 ? 0 : (suffix.charAt(suffix.length() - 1) - 'a' + 1);

            int z = a * 27 + b;
            if (now.next[z] == null) return -1;
            now = now.next[z];

            if (prefix.length() > 0) {
                prefix = prefix.substring(1);
            }

            if (suffix.length() > 0) {
                suffix = suffix.substring(0, suffix.length() - 1);
            }
        }

        return now.wordIndex.get(now.wordIndex.size() - 1);
    }


    public static void main(String[] args) {

        A4 obj = new A4(new String[]{
                "apple"
        });

        System.out.println(obj.f("a", "e"));
        System.out.println(obj.f("b", ""));


    }

}
