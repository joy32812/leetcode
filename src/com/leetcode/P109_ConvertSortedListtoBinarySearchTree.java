package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 08/03/2017.
 */
public class P109_ConvertSortedListtoBinarySearchTree {
    public TreeNode creatTree(int [] nums, int l, int r) {
        if (l > r) {return null;}
        int mid = (l + r) / 2;
        TreeNode now = new TreeNode(nums[mid]);
        now.left = creatTree(nums, l, mid - 1);
        now.right = creatTree(nums, mid + 1, r);

        return now;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return creatTree(nums, 0, nums.length - 1);
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode head2 = head;
        int cnt = 0;
        while (head2 != null) {
            cnt ++;
            head2 = head2.next;
        }

        int[] nums = new int[cnt];
        int i = 0;
        while (head != null) {
            nums[i++] = head.val;
            head = head.next;
        }

        return sortedArrayToBST(nums);
    }

    public static void main(String[] args) {
    }
}
