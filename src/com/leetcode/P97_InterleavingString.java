package com.leetcode;

/**
 * Created by xiaoyuan on 06/03/2017.
 */
public class P97_InterleavingString {

    private int[][][] visit;

    public boolean dfs(String s1, String s2, String s3, int i1, int i2, int i3) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        }

        if (visit[i1][i2][i3] != 0) {return visit[i1][i2][i3] == 1;}

        boolean result = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
             result = dfs(s1, s2, s3, i1 + 1, i2, i3 + 1);
        }
        if (result == false && i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            result = dfs(s1, s2, s3, i1, i2 + 1, i3 + 1);
        }

        visit[i1][i2][i3] = 1;
        if (result == false) {
            visit[i1][i2][i3] = 2;
        }

        return visit[i1][i2][i3] == 1;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        if (len1 + len2 != len3) {return false;}

        visit = new int[len1 + 1][len2 + 1][len3 + 1];
        return dfs(s1, s2, s3, 0, 0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new P97_InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new P97_InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

}
