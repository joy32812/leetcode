package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 05/03/2017.
 */
public class P89_GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        if (n == 0) {
            return ans;
        }

        // 1
        ans.add(1);

        for (int i = 2; i <= n; i++) {
            int size = ans.size();
            for (int j = size - 1; j >= 0; j--) {
                ans.add((1 << (i - 1)) + ans.get(j));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P89_GrayCode().grayCode(0));
        System.out.println(new P89_GrayCode().grayCode(1));
        System.out.println(new P89_GrayCode().grayCode(2));
        System.out.println(new P89_GrayCode().grayCode(3));
    }

}
