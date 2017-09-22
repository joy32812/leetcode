package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 22/09/2017.
 */
public class P642_DesignSearchAutocompleteSystem {

    private class TrieNode {
        LinkedList<WordCnt> words;
        Map<Character, TrieNode> next;

        public TrieNode () {
            this.words = new LinkedList<>();
            this.next = new HashMap<>();
        }
    }

    private class WordCnt {
        int cnt;
        String word;

        public WordCnt(int cnt, String word) {
            this.cnt = cnt;
            this.word = word;
        }
    }


    Map<String, Integer> cntMap;
    TrieNode root;
    StringBuilder sb;
    public P642_DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuilder();
        root = new TrieNode();
        cntMap = new HashMap<>();

        List<WordCnt> words = new ArrayList<>();

        for (int i = 0; i < sentences.length; i++) {
            words.add(new WordCnt(times[i], sentences[i]));
            cntMap.put(sentences[i], cntMap.getOrDefault(sentences[i], 0) + times[i]);
        }

        words.sort(new Comparator<WordCnt>() {
            @Override
            public int compare(WordCnt o1, WordCnt o2) {
                if (o1.cnt != o2.cnt) return o2.cnt - o1.cnt;
                return o1.word.compareTo(o2.word);
            }
        });


        for (WordCnt w : words) {
            build(root, w.word, w.cnt);
        }

    }

    private void build(TrieNode root, String w, int cnt) {
        TrieNode now = root;
        for (char ch : w.toCharArray()) {
            if (!now.next.containsKey(ch)) {
                now.next.put(ch, new TrieNode());
            }

            now = now.next.get(ch);
            boolean has = false;
            for (WordCnt wordCnt : now.words) {
                if (wordCnt.word.equals(w)) {
                    has = true;
                    wordCnt.cnt = cnt;
                }
            }
            if (!has) {
                now.words.add(new WordCnt(cnt, w));
            }

            now.words.sort(new Comparator<WordCnt>() {
                @Override
                public int compare(WordCnt o1, WordCnt o2) {
                    if (o1.cnt != o2.cnt) return o2.cnt - o1.cnt;
                    return o1.word.compareTo(o2.word);
                }
            });
            while (now.words.size() > 3) {now.words.removeLast();}
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            cntMap.put(sb.toString(), cntMap.getOrDefault(sb.toString(), 0) + 1);
            build(root, sb.toString(), cntMap.get(sb.toString()));

            sb = new StringBuilder();
            return new ArrayList<>();
        }

        sb.append(c);

        TrieNode now = root;
        for (char ch : sb.toString().toCharArray()) {
            if (!now.next.containsKey(ch)) {
                return new ArrayList<>();
            }
            now = now.next.get(ch);
        }

        List<String> ans = new ArrayList<>();

        for (WordCnt wordCnt : now.words) {
            ans.add(wordCnt.word);
        }

        return ans;
    }

    public static void main(String[] args) {

        P642_DesignSearchAutocompleteSystem obj = new P642_DesignSearchAutocompleteSystem(new String[]{"i love you","island","iroman","i love leetcode"}, new int[]{5, 3, 2, 2});

        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));

        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));

        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));
    }

}
