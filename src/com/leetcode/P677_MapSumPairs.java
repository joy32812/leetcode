package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 17/09/2017.
 */
public class P677_MapSumPairs {

    private class TrieNode {
        long sum;
        Map<Character, TrieNode> next;
        boolean isWord;

        public TrieNode() {
            this.sum = 0;
            this.next = new HashMap<>();
        }
    }

    Map<String, Integer> valueMap;
    TrieNode root;

    /** Initialize your data structure here. */
    public P677_MapSumPairs() {
        valueMap = new HashMap<>();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int diff = val;
        if (valueMap.containsKey(key)) {
            diff = val - valueMap.get(key);
        }
        valueMap.put(key, val);

        build(root, key, diff);
    }

    private void build(TrieNode root, String key, int diff) {
        TrieNode now = root;

        for (char ch : key.toCharArray()) {
            if (!now.next.containsKey(ch)) {
                now.next.put(ch, new TrieNode());
            }
            now = now.next.get(ch);
            now.sum += diff;
        }
        now.isWord = true;
    }

    public int sum(String prefix) {
        long sum = 0;
        TrieNode now = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!now.next.containsKey(ch)) {
                return 0;
            }
            now = now.next.get(ch);
            sum += now.sum;

            long noneSum = 0;

            if (i != prefix.length() - 1) {
                char z = prefix.charAt(i + 1);
                for (char t : now.next.keySet()) {
                    if (t == z) {continue;}
                    noneSum += now.next.get(t).sum;
                }
            }

            long sameSum = 0;
            if (now.isWord && i != prefix.length() - 1) {
                for (char t : now.next.keySet()) {
                    sameSum += now.next.get(t).sum;
                }

                noneSum += (now.sum - sameSum);
            }
            sum -= (i + 1) * noneSum;
        }

        return (int)(sum / prefix.length());
    }

    public static void main(String[] args) {
        P677_MapSumPairs obj = new P677_MapSumPairs();

        obj.insert("aa", 2);
        obj.insert("aaa", 3);
        obj.insert("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj", 1111);
        obj.insert("bb", 143);
        obj.insert("cc", 144);
        obj.insert("aew", 145);
        obj.insert("aab", 33);
        System.out.println(obj.sum("aab"));
    }

}
