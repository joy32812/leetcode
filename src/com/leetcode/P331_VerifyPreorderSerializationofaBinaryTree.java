package com.leetcode;

/**
 * Created by xiaoyuan on 08/05/2017.
 */
public class P331_VerifyPreorderSerializationofaBinaryTree {

    private int[][] dp;
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {return false;}
        String[] s = preorder.split(",");

        dp = new int[s.length + 1][s.length + 1];

        return ifValid(s, 0, s.length - 1);
    }

    private boolean ifValid(String[] s, int l, int r) {
        if (l > r) {return false;}

        if (dp[l][r] != 0) {return dp[l][r] == 1;}

        if (l == r && s[l].equals("#")) {dp[l][r]=1;return true;}
        if (s[l].equals("#")) {dp[l][r]=2;return false;}
        if (!(s[r].equals("#") && s[r - 1].equals("#"))) {dp[l][r]=2;return false;}

        for (int i = 1; i < (r - l + 1); i += 2) {
            if (ifValid(s, l + 1, l + 1 + i - 1) && ifValid(s, l + 1 + i, r)) {
                dp[l][r]=1;
                return true;
            }
        }

        dp[l][r] = 2;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P331_VerifyPreorderSerializationofaBinaryTree().isValidSerialization("9,9,9,9,9,9,9,9,#,#,#,9,9,9,9,#,#,#,9,9,#,9,#,#,9,9,9,#,#,9,#,#,9,#,#,9,#,#,9,#,9,9,9,9,#,9,#,#,9,9,9,#,9,9,#,#,#,9,#,#,9,9,#,#,9,9,#,#,#,#,9,#,#,9,#,9,9,9,9,#,#,9,#,#,9,9,#,#,9,#,9,#,#,9,9,9,9,9,#,#,9,9,#,#,#,9,9,9,#,#,9,#,#,9,9,9,#,#,#,#,9,9,9,9,#,#,9,#,#,9,9,9,#,#,9,#,9,#,#,9,#,#,9,9,9,#,#,#,9,9,9,#,#,#,9,#,#,9,#,9,#,9,#,#,9,#,9,9,9,#,#,9,9,#,#,#,9,9,#,9,#,#,9,#,9,9,#,9,9,9,#,#,9,9,#,#,#,9,#,9,#,9,#,9,9,#,#,#,9,9,#,#,9,9,9,9,9,#,#,#,9,#,#,#,#,9,9,9,9,9,#,#,#,#,9,#,9,9,9,#,9,#,#,9,#,#,#,9,9,#,9,9,9,#,#,#,9,9,9,9,9,#,#,#,9,#,9,#,#,9,#,#,#,9,9,9,9,9,#,#,#,9,9,9,#,#,#,9,9,9,#,#,9,9,#,#,9,9,9,9,9,#,9,#,#,#,9,9,9,#,9,#,9,#,#,9,9,9,9,#,#,#,#,9,#,#,9,9,#,#,#,9,9,#,9,#,#,9,#,9,#,#,#,9,9,#,9,9,#,#,#,9,9,9,#,#,9,#,9,#,#,#,9,9,9,9,9,#,#,9,#,9,9,#,#,#,9,#,#,9,9,9,#,9,#,#,9,#,#,9,#,9,#,9,9,#,#,#,9,9,9,#,#,#,9,#,9,#,#,9,9,9,9,#,9,#,#,9,9,#,9,9,9,#,#,9,#,#,#,9,9,9,#,#,9,#,9,#,#,9,9,9,#,#,9,#,#,9,#,#,9,#,#,9,9,9,#,#,9,9,#,9,#,#,#,9,9,9,#,#,9,#,9,9,#,#,#,#,9,9,#,#,9,9,#,9,#,#,9,9,9,9,#,#,#,9,#,9,#,#,#"));

        System.out.println(new P331_VerifyPreorderSerializationofaBinaryTree().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new P331_VerifyPreorderSerializationofaBinaryTree().isValidSerialization("1,#"));
        System.out.println(new P331_VerifyPreorderSerializationofaBinaryTree().isValidSerialization("9,#,#,1"));
    }

}
