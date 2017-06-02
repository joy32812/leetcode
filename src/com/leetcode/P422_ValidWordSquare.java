package com.leetcode;

import java.util.List;

/**
 * Created by xiaoyuan on 02/06/2017.
 */
public class P422_ValidWordSquare {

    public boolean validWordSquare(List<String> words) {

        int n = words.size();
        for (int i = 0; i < n; i++) {
            String w = words.get(i);
            for (int j = 0; j < w.length(); j++) {
                char ch = w.charAt(j);

                if (words.size() <= j) {return false;}
                if (words.get(j).length() <= i) {return false;}
                if (words.get(j).charAt(i) !=  ch) {return false;}
            }
        }

        return true;
    }

    public static void main(String[] args) {
    }

}
