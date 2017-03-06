package com.leetcode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaoyuan on 06/03/2017.
 *
 * use mask to indicate numbers we can use
 */
public class P96_UniqueBinarySearchTrees {

    private long[] visit;

    public int numTrees(int n) {
        if (visit == null) {
            visit = new long[n + 1];
        }
        if (visit[n] > 0) {
            return (int)visit[n];
        }
        return (int)(visit[n] = dfs((1 << n) - 1));
    }

    private long dfs(long mask) {
        long result = 0;
        if (mask == 0) {
            return 1;
        }

        long left = 0;
        long right = 0;
        for (int i = 1; i <= 63; i++) {
            if ((1 << (i - 1)) > mask) {
                break;
            }

            if (((1 << (i - 1)) & mask) > 0 ) {
                right = 0;
                for (int j = i + 1; j <= 63; j++) {
                    if ((1 << (j - 1)) > mask) {break;}
                    if (((1 << (j - 1)) & mask) > 0 ) {
                        right ++;
                    }
                }

                long leftAns = numTrees((int)left);
                long rightAns = numTrees((int)right);
                result += leftAns * rightAns;

                left ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        int ans = new P96_UniqueBinarySearchTrees().numTrees(30);
        System.out.println(ans);
        System.out.println(new Date().getTime());
    }

}
