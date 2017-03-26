package com.leetcode;

/**
 * Created by xiaoyuan on 26/03/2017.
 *
 * bucket sort
 */
public class P164_MaximumGap {

    private class Node {
        int minVal;
        int maxVal;

        public Node(int minVal, int maxVal) {
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {return 0;}

        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int size = (int)Math.ceil((1.0 + max - min) / (nums.length - 1));

        Node[] bucket = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int bNum = (nums[i] - min) / size;
            if(bucket[bNum] == null) {
                bucket[bNum] = new Node(nums[i], nums[i]);
            } else {
                bucket[bNum].minVal = Math.min(bucket[bNum].minVal, nums[i]);
                bucket[bNum].maxVal = Math.max(bucket[bNum].maxVal, nums[i]);
            }
        }

        int ans = bucket[0].maxVal - bucket[0].minVal;
        Node lastNode = bucket[0];
        for (int i = 1; i < nums.length; i++) {
            if (bucket[i] != null) {
                ans = Math.max(ans, bucket[i].minVal - lastNode.maxVal);

                lastNode = bucket[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P164_MaximumGap().maximumGap(new int[]{1, 9, 2, 500, 10, 501}));
    }
}
