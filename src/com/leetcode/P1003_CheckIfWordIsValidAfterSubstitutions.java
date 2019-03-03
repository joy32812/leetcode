package com.leetcode;

public class P1003_CheckIfWordIsValidAfterSubstitutions {


    public boolean isValid(String S) {

        while (S.length() > 0) {
            int pos = -1;
            for (int i = 0; i + 2 < S.length(); i++) {
                if (S.charAt(i) == 'a' && S.charAt(i + 1) == 'b' && S.charAt(i + 2) == 'c') {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) return false;
            S = S.substring(0, pos) + S.substring(pos + 3, S.length());
        }

        return true;
    }

    /**
     * much more simple
     * @param S
     * @return
     */
    public boolean isValid2(String S) {
        while(S.indexOf("abc") != -1) {
            S = S.replaceAll("abc","");
        }
        return S.isEmpty();
    }


    public static void main(String[] args) {

    }

}
