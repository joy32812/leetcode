package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P556_NextGreaterElementIII {

    public int nextGreaterElement(int n) {

        List<Integer> nums = new ArrayList<>();
        int tmpN = n;
        while (tmpN > 0) {
            nums.add(tmpN % 10);
            tmpN /= 10;
        }

        Collections.reverse(nums);

        boolean exist = false;
        int pos = -1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                exist = true;
                pos = i;
            }
        }
        if (!exist) {return -1;}

        for (int i = pos + 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(pos) && nums.get(i) > nums.get(pos - 1)) {
                int tmp = nums.get(pos);
                nums.set(pos, nums.get(i));
                nums.set(i, tmp);
            }
        }


        long ans = 0;
        for (int i = 0; i < pos - 1; i++) {
            ans = ans * 10 + nums.get(i);
        }

        ans = ans * 10 + nums.get(pos);

        List<Integer> restList = new ArrayList<>();
        restList.add(nums.get(pos - 1));
        for (int i = pos + 1; i < nums.size(); i++) {
            restList.add(nums.get(i));
        }
        restList.sort((a, b) -> (a - b));

        for (int d : restList) {
            ans = ans * 10 + d;
        }

        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(new P556_NextGreaterElementIII().nextGreaterElement(1999999999));
    }

}
