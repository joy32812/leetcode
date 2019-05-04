package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class P804_UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> ans = new HashSet<>();

        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : w.toCharArray()) sb.append(morse[ch - 'a']);

            ans.add(sb.toString());
        }

        return ans.size();
    }

}
