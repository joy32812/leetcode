package com.leetcode;

/**
 * Created by xiaoyuan on 11/06/2017.
 */
public class P473_MatchstickstoSquare {

    int edge;
    boolean ans;
    boolean[] used;
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {return false;}

        used = new boolean[nums.length];

        int sum = 0;
        for (int d : nums) {sum += d;}
        if (sum % 4 != 0) {return false;}
        for (int d : nums) {
            if (d > sum / 4) {return false;}
        }

        edge = sum / 4;
        ans = false;
        dfs(nums, 0, 0);

        return ans;
    }


    private void dfs(int[] nums, int sum, int cnt) {

        if (ans) {return;}
        if (sum == edge) {
            if (cnt + 1 == 3) {
                ans = true;
                return;
            }

            dfs(nums, 0, cnt + 1);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {continue;}

            used[i] = true;
            if (sum + nums[i] <= edge) {dfs(nums, sum + nums[i], cnt);}
            if (ans) {return;}
            used[i] = false;

            if (sum == 0) {break;}
        }
    }

    public static void main(String[] args) {
//        System.out.println(new P473_MatchstickstoSquare().makesquare(new int[]{16,5,5,5,5,4,4,4,4,4,4,3,3,3,3}));
        System.out.println(new P473_MatchstickstoSquare().makesquare(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
//        System.out.println(new P473_MatchstickstoSquare().makesquare(new int[]{5,5,5,5,16,4,4,4,4,4,3,3,3,3,4}));
//        System.out.println(new P473_MatchstickstoSquare().makesquare(new int[]{1, 1, 2, 2, 2}));
    }

}
