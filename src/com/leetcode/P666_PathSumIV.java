package com.leetcode;

import java.util.Arrays;

/**
 * Created by xiaoyuan on 27/08/2017.
 */
public class P666_PathSumIV {

    int ans;
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {return 0;}

        int[][] trees = new int[10][20];
        for (int i = 0; i < trees.length; i++) {
            Arrays.fill(trees[i], -1);
        }

        for (int i = 0; i < nums.length; i++) {
            int d = nums[i] / 100;
            int p = nums[i] % 100 / 10;
            int v = nums[i] % 10;

            trees[d][p] = v;
        }

        ans = 0;
        work(trees, 1, 1, 0);

        return ans;
    }

    private void work(int[][] trees, int d, int p, int now) {
        if (trees[d][p] == -1) {return;}

        if (trees[d + 1][2 * p - 1] == -1 && trees[d + 1][2 * p] == -1) {
            ans += now + trees[d][p];
            return;
        }

        work(trees, d + 1, 2 * p - 1, now + trees[d][p]);
        work(trees, d + 1, 2 * p, now + trees[d][p]);

    }

    public static void main(String[] args) {
        System.out.println(new P666_PathSumIV().pathSum(new int[]{111, 217, 221, 315, 415}));
    }

}
