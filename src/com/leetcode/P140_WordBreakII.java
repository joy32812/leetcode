package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 19/03/2017.
 *
 * use search technique backwards to get list
 */
public class P140_WordBreakII {

    private List<String> wordDictCopy;
    private List<List<Integer>> from;
    private List<String> result;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDictCopy = wordDict;

        from = new ArrayList<List<Integer>>();
        for (int i = 0; i <= s.length(); i++) {from.add(new ArrayList<Integer>());}

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String word = wordDict.get(j);
                if (i - word.length() >= 0 && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                    from.get(i).add(j);
                }
            }
        }

        result = new ArrayList<String>();

        LinkedList<String> q = new LinkedList<String>();
        dfs(s, s.length(), q);

        return result;
    }

    private void dfs(String s, int pos, LinkedList<String> q) {
        if (pos <= 0) {
            StringBuilder sb = new StringBuilder();
            for (String word : q) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(new StringBuilder(word).reverse().toString());
            }
            result.add(sb.reverse().toString());

            return;
        }

        List<Integer> wordIndexList = from.get(pos);
        for (int i : wordIndexList) {
            String word = wordDictCopy.get(i);
            q.add(word);
            dfs(s, pos - word.length(), q);
            q.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new P140_WordBreakII().wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }

}
