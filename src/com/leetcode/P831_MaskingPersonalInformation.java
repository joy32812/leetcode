package com.leetcode;

public class P831_MaskingPersonalInformation {

    public String maskPII(String S) {
        if (S.indexOf('@') > -1) return maskEmail(S);
        return maskTelephone(S);
    }

    private String maskTelephone(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) sb.append(ch);
        }

        String filterS = sb.toString();
        String local = "***-***-" + filterS.substring(filterS.length() - 4);
        if (filterS.length() == 10) return local;
        return "+" + getStar(filterS.length() - 10) + "-" + local;
    }

    private String getStar(int n) {
        String star = "";
        for (int i = 0; i < n; i++) star += "*";
        return star;
    }

    private String maskEmail(String s) {
        s = s.toLowerCase();
        String firstName = s.split("@")[0];
        return firstName.charAt(0) + "*****" + firstName.charAt(firstName.length() - 1) + s.substring(firstName.length());
    }

}
