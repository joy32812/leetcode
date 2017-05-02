package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 02/05/2017.
 */
public class P315_CountofSmallerNumbersAfterSelf {

    private class TNode {
        int val;
        int leftNum;
        int cnt;

        TNode left, right;

        public TNode(int val, int leftNum, int cnt) {
            this.val = val;
            this.leftNum = leftNum;
            this.cnt = cnt;
        }
    }

    private TNode root;

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {return new ArrayList<>();}

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }


        root = new TNode(nums[0], 0, 1);
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        for (int i = 1; i < nums.length; i++) {
            ans.add(insert(root, nums[i]));
        }


        l = 0;
        r = ans.size() - 1;
        while (l < r) {
            int tmp = ans.get(l);
            ans.set(l, ans.get(r));
            ans.set(r, tmp);

            l++;
            r--;
        }

        return ans;
    }

    private int insert(TNode root, int num) {

        if (root.val > num) {
            root.leftNum ++;

            if (root.left == null) {
                root.left = new TNode(num, 0, 1);
                return 0;
            }
            return insert(root.left, num);
        } else if (root.val == num){
            root.cnt ++;
            return root.leftNum;
        } else {
            if (root.right == null) {
                root.right = new TNode(num, 0, 1);
                return root.leftNum + 1 + root.cnt - 1;
            }

            return root.leftNum + 1 + (root.cnt - 1) + insert(root.right, num);
        }
    }


    public static void main(String[] args) {
        System.out.println(new P315_CountofSmallerNumbersAfterSelf().countSmaller(new int[]{26, 78, 27, 1, 1}));
//        System.out.println(new P315_CountofSmallerNumbersAfterSelf().countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
    }

}
