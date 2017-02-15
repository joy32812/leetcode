package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 15/02/2017.
 * 暴力递归, 以为要超时
 */
public class LetterCombinationsofaPhoneNumber17 {

    public List<String> letterCombinations(String digits) {
        final String[] num2Chars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length() < 1) {
            return result;
        }


        int theNum = Integer.parseInt("" + digits.charAt(0));
        List<String> othetResult = letterCombinations(digits.substring(1));

        if (num2Chars[theNum].length() < 1) {
            return othetResult;
        }
        for (int i = 0; i < num2Chars[theNum].length(); i++) {
            if (othetResult.size() == 0) {
                othetResult.add("");
            }
            for (int j = 0; j < othetResult.size(); j++) {
                result.add("" + num2Chars[theNum].charAt(i) + othetResult.get(j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber17().letterCombinations("23"));
    }
}
