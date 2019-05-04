package com.leetcode;

public class P758_BoldWordsinString {

    public String boldWords(String[] words, String S) {

        boolean[] bold = new boolean[S.length()];

        for (String w : words) {
            for (int i = 0; i < S.length(); i++) {
                if (i + w.length() > S.length()) continue;
                if (w.equals(S.substring(i, i + w.length()))) {
                    for (int j = i; j < i + w.length(); j++) bold[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (bold[i] && (i - 1 < 0 || !bold[i - 1])) sb.append("<b>");
            sb.append(S.charAt(i));
            if (bold[i] && (i + 1 == S.length() || !bold[i + 1])) sb.append("</b>");
        }

        return sb.toString();
    }

}
