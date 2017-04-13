package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P248_StrobogrammaticNumberIII {

    private int[] mapArr = new int[]{0, 1, -1, -1, -1, -1, 9, -1, 8, -1};
    private String numberString;
    private int ans;
    int len;

    private Map<Character, Character> charMap;

    public boolean isStrobogrammatic(String num) {
        charMap = new HashMap<>();
        charMap.put('0', '0');
        charMap.put('1', '1');
        charMap.put('8', '8');
        charMap.put('6', '9');
        charMap.put('9', '6');

        int l = 0;
        int r = num.length() - 1;
        while (l <= r) {
            char lch = num.charAt(l);
            char rch = num.charAt(r);
            if (charMap.get(lch) == null || charMap.get(rch) == null) {return false;}
            if (!(charMap.get(lch) == rch && charMap.get(rch) == lch)) {return false;}
            l++;
            r--;
        }

        return true;
    }

    public int findStrobogrammatic(int n, String numStr) {
        ans = 0;
        len = n;
        numberString = numStr;

        dfs(0, n - 1, "", "");

        return ans;
    }

    public int strobogrammaticInRange(String low, String high) {

        int lowCnt = 0;
        for (int i = 1; i <= low.length(); i++) {
            lowCnt += findStrobogrammatic(i, low);
        }

        int highCnt = 0;
        for (int i = 1; i <= high.length(); i++) {
            highCnt += findStrobogrammatic(i, high);
        }

        int result = highCnt - lowCnt + (isStrobogrammatic(low) ? 1 : 0);
        return result < 0 ? 0 : result;

    }

    private void dfs(int l, int r, String start, String end) {
        if (l > r) {
            if (len == numberString.length()) {
                String ss = start + end;
                if (ss.compareTo(numberString) <= 0) {
                    ans++;
                }
            } else {
                ans ++;
            }
            return;
        }

        if (l == r) {
            for (int i = 0; i < mapArr.length; i++) {
                if (mapArr[i] < 0) {continue;}
                if (mapArr[i] != i) {continue;}
                dfs(l + 1, r - 1, start + i, end);
            }
        } else {
            for (int i = 0; i < mapArr.length; i++) {
                if (l == 0 && i == 0) {continue;}
                if (mapArr[i] < 0) {continue;}
                dfs(l + 1, r - 1, start + i, mapArr[i] + end);
                if (i != mapArr[i]) {
                    dfs(l + 1, r - 1, start + mapArr[i], i + end);
                }
            }
        }
    }

    public static void main(String[] args) {
        P248_StrobogrammaticNumberIII obj = new P248_StrobogrammaticNumberIII();
        System.out.println(obj.strobogrammaticInRange("0", "0"));
    }

}
