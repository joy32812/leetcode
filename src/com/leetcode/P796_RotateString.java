package com.leetcode;

public class P796_RotateString {

    public boolean rotateString2(String A, String B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.length() != B.length()) return false;
        if (A.length() == 0) return true;

        for (int i = 0; i < A.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(A.substring(i));
            sb.append(A.substring(0, i));

            if (B.equals(sb.toString())) return true;
        }

        return false;
    }

    public boolean rotateString(String A, String B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;

        return A.length() == B.length() && (A + A).contains(B);
    }

}
