package com.leetcode;

/**
 * Created by xiaoyuan on 30/04/2017.
 */
public class P318_MaximumProductofWordLengths {

    public int maxProduct(String[] words) {

        if (words == null || words.length == 0) {return 0;}
        int n = words.length;

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = getIntValue(words[i]);
        }
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++){
                if ((data[i] & data[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

    private int getIntValue(String word) {
        int res = 0;

        for (char ch : word.toCharArray()) {
            res |=  (1 << (ch - 'a'));
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new P318_MaximumProductofWordLengths().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }
}
