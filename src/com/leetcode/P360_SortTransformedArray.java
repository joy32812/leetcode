package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiaoyuan on 14/05/2017.
 */
public class P360_SortTransformedArray {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {return new int[]{};}

        int[] ans = new int[nums.length];

        if (nums.length == 1) {
            ans[0] = a * nums[0] * nums[0] + b * nums[0] + c;
            return ans;
        }

        List<Integer> now = new ArrayList<>();
        if (a == 0) {
            for (int d : nums) {now.add(b * d + c);}
        } else {
            int half = (int)Math.floor(-1.0 * b / (2.0 * a));
            int pos = Arrays.binarySearch(nums, half);
            if (pos < 0) {
                pos = - (pos + 1);
            }
            if (pos == 0 || pos == nums.length) {
                for (int d : nums) {
                    now.add(a * d * d + b * d + c);
                }
            } else {
                int l = pos - 1, r = pos;


                if (pos + 1 < nums.length - 1) {
                    int z = pos + 1;

                    int L = a * nums[l] * nums[l] + b * nums[l]  + c;
                    int R = a * nums[r] * nums[r] + b * nums[r]  + c;
                    int Z = a * nums[z] * nums[z] + b * nums[z]  + c;

                    if ((a > 0 && Z < L) || (a < 0 && Z > L)) {
                        l = pos;
                        r = pos + 1;
                    }
                }


                while (true) {
                    if (l >= 0 && r <= nums.length - 1) {
                        int L = a * nums[l] * nums[l] + b * nums[l]  + c;
                        int R = a * nums[r] * nums[r] + b * nums[r]  + c;

                        if (a > 0) {
                            if (L <= R) {
                                l--;
                                now.add(L);
                            } else {
                                r++;
                                now.add(R);
                            }
                        } else {
                            if (L >= R) {
                                l--;
                                now.add(L);
                            } else {
                                r++;
                                now.add(R);
                            }
                        }
                    } else if (l >= 0) {
                        int L = a * nums[l] * nums[l] + b * nums[l]  + c;
                        l--;
                        now.add(L);
                    } else if (r <= nums.length - 1) {
                        int R = a * nums[r] * nums[r] + b * nums[r]  + c;
                        r++;
                        now.add(R);
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < now.size(); i++) {
            ans[i] = now.get(i);
        }

        if (ans[0] > ans[ans.length - 1]) {
            int l = 0, r = ans.length - 1;
            while (l < r) {
                int tmp = ans[l];
                ans[l] = ans[r];
                ans[r] = tmp;

                l++;
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P360_SortTransformedArray().sortTransformedArray(new int[]{
                -97,-95,-82,-81,-76,-75,-74,-73,-72,-69,-68,-66,-64,-61,-56,-53,-51,-50,-47,-46,-43,-41,-39,-33,-30,-30,-29,-28,-27,-26,-25,-25,-23,-22,-18,-16,-16,-15,-9,-4,-2,-1,5,16,20,20,21,21,24,24,33,39,40,44,44,49,51,53,54,55,57,58,58,59,62,63,65,67,68,69,71,72,73,73,74,76,77,78,79,81,88,90,91,92,92,96,97
        }, 31, 71, 96));
    }

}
