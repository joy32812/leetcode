package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P824_GoatLatin {

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");

        int n = words.length;
        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[i] = convert(words[i], i + 1);
        }

        return String.join(" ", ans);
    }

    private String convert(String word, int x) {

        char[] vowelArr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowelSet =  new HashSet<>();
        for (char ch : vowelArr) vowelSet.add(ch);


        StringBuilder sb = new StringBuilder();
        char firstCh = word.charAt(0);
        if (vowelSet.contains(firstCh)) {
            sb.append(word);
            sb.append("ma");
        } else {
            sb.append(word.substring(1));
            sb.append(firstCh);
            sb.append("ma");
        }

        for (int i = 0; i < x; i++) sb.append('a');

        return sb.toString();
    }

}
