package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 05/06/2017.
 */
public class P423_ReconstructOriginalDigitsfromEnglish {

    public String originalDigits(String s) {
        String[] orders = {"zero", "two", "four", "six", "eight", "one", "seven", "five", "three", "nine"};
        String[] letters = {"z", "w", "u", "x", "g", "o", "s", "v", "t", "i"};
        int[] nums = {0, 2, 4, 6, 8, 1, 7, 5, 3, 9};

        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!cntMap.containsKey(ch)) {cntMap.put(ch, 0);}
            cntMap.put(ch, cntMap.get(ch) + 1);
        }

        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            char mainLetter = letters[i].charAt(0);
            if (!cntMap.containsKey(mainLetter) || cntMap.get(mainLetter) == 0) {continue;}

            int cnt = cntMap.get(mainLetter);
            for (int j = 0; j < cnt; j++) {ints.add(nums[i]);}

            for (char ch : orders[i].toCharArray()) {
                cntMap.put(ch, cntMap.get(ch) - cnt);
            }
        }

        ints.sort((a, b)->(a - b));

        StringBuilder sb = new StringBuilder();
        for (int d : ints) {sb.append(d);}


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P423_ReconstructOriginalDigitsfromEnglish().originalDigits("owoztneoer"));
    }

}
