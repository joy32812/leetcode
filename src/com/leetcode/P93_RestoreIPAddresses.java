package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyuan on 06/03/2017.
 *
 * 1. 先写测试用例 TDD, 考虑所有可能情况
 * 2. 搜索尽量使用剪枝
 */
public class P93_RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();

        LinkedList<String> used = new LinkedList<String>();


        dfs(s, 0, used, result);
        return result;
    }

    private void dfs(String s, int pos, LinkedList<String> used, List<String> result) {

        int maxLen = (4 - used.size()) * 3;
        if (s.length() - pos > maxLen) {
            return;
        }

        if (pos == s.length() && used.size() == 4) {
            StringBuilder sb = new StringBuilder();
            for (String ss : used) {
                if (sb.length() > 0) {
                    sb.append(".");
                }
                sb.append(ss);
            }
            result.add(sb.toString());
            return;
        }

        int len = Math.min(s.length() - 1, pos + 2);
        for (int i = pos; i <= len; i++) {
            if (okay(s, pos, i)) {
                used.add(s.substring(pos, i + 1));
                dfs(s, i + 1, used, result);
                used.removeLast();
            }
        }

    }

    private boolean okay(String s, int begin, int end) {
        if (end - begin > 0 && s.charAt(begin) == '0') {return false;}
        int a = Integer.parseInt(s.substring(begin, end + 1));
        return a >= 0 && a <= 255;
    }

    public static void main(String[] args) {
        System.out.println(new P93_RestoreIPAddresses().restoreIpAddresses("11111111111111111111111"));

        System.out.println(new P93_RestoreIPAddresses().restoreIpAddresses("1202332255"));
        System.out.println(new P93_RestoreIPAddresses().restoreIpAddresses("25525511135"));
        System.out.println(new P93_RestoreIPAddresses().restoreIpAddresses("0000"));
    }

}
