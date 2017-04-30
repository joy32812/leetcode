package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 30/04/2017.
 */
public class P320_GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        if (word == null || word.length() == 0) {
            ans.add("");
            return ans;
        }

        List<String> pres = generateAbbreviations(word.substring(1));

//        if (pres.size() == 0) {
//            ans.add("1");
//            ans.add(word);
//            return ans;
//        }

        for (String w : pres) {
            ans.add(addOne(w));
            ans.add(word.charAt(0) + w);
        }

        return ans;
    }

    private String addOne(String w) {

        int d = 0;
        int k = -1;
        for (int i = 0; i < w.length(); i++) {
            if (Character.isDigit(w.charAt(i))) {
                d = d * 10 + (w.charAt(i) - '0');
                k = i;
            } else {
                break;
            }
        }
        d++;

        return "" + d + w.substring(k + 1);
    }

    public static void main(String[] args) {

        String w = "";
        System.out.println(w.substring(2));


//        System.out.println(new P320_GeneralizedAbbreviation().generateAbbreviations(""));
//        System.out.println(new P320_GeneralizedAbbreviation().generateAbbreviations("word"));
    }

}
