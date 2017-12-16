package com.leetcode;

/**
 * Created by xiaoyuan on 10/12/2017.
 */
public class P744_FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        for (char ch : letters) {
            if (ch > target) return ch;
        }

        return letters[0];
    }



    public static void main(String[] args) {

    }

}
