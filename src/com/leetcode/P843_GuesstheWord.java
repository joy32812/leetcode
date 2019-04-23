package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

interface Master {
     public int guess(String word);
 }
public class P843_GuesstheWord {

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> ansList = Arrays.stream(wordlist).collect(Collectors.toList());

        for (int i = 0; i < 10; i++) {
            if (ansList.isEmpty()) return;

            String next = ansList.get(new Random().nextInt(ansList.size()));
            int match = master.guess(next);
            if (match == 6) return;


            List<String> otherSet = new ArrayList<>();
            for (String t : ansList) {
                if (getMatchNum(next, t) == match) otherSet.add(t);
            }

            ansList = otherSet;
        }

    }

    private int getMatchNum(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
    }

}
