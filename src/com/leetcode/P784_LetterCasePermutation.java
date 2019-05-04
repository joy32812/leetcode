package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P784_LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> ans = new LinkedList<>();
        if (S == null || S.length() == 0) return ans;


        int n = 0;
        for (char ch : S.toCharArray()) {
            if (Character.isLetter(ch)) n++;
        }


        for (int i = 0; i < (1 << n); i++) {

            int t = 0;
            StringBuilder sb = new StringBuilder();
            for (char ch : S.toCharArray()) {
                if (!Character.isLetter(ch)) {
                    sb.append(ch);
                    continue;
                }

                if ((i & (1 << t)) > 0) {
                    sb.append(Character.toUpperCase(ch));
                } else {
                    sb.append(Character.toLowerCase(ch));
                }

                t ++;
            }

            ans.add(sb.toString());

        }

        return ans;
    }

}
