package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by xiaoyuan on 05/05/2017.
 */
public class P321_CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        LinkedList<Integer> ans =  work(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
        System.out.println(ans);

        int[] ret = new int[k];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }

        return ret;
    }

    private LinkedList<Integer> work(int[] A, int la, int ra, int[] B, int lb, int rb, int k) {
        if (k == 0) {
            return new LinkedList<>();
        }
        if (ra - la + 1 + rb - lb + 1 == k) {
            LinkedList<Integer> ans = new LinkedList<>();

            int aa = la;
            int bb = lb;
            while (ans.size() < k) {
                if (aa <= ra && bb <= rb) {
                    if (A[aa] >= B[bb]) {
                        ans.add(A[aa++]);
                    } else {
                        ans.add(B[bb++]);
                    }
                } else if (aa <= ra) {
                    ans.add(A[aa++]);
                } else {
                    ans.add(B[bb++]);
                }
            }

            return ans;
        }

        TreeSet<Integer>[] posA = new TreeSet[10];
        TreeSet<Integer>[] posB = new TreeSet[10];
        for (int i = 0; i < 10; i++) {
            posA[i] = new TreeSet<>();
            posB[i] = new TreeSet<>();
        }
        for (int i = la; i <= ra; i ++) {
            posA[A[i]].add(i);
        }
        for (int i = lb; i <= rb; i ++) {
            posB[B[i]].add(i);
        }


        for (int i = 9; i >= 0; i--) {
            if (!posA[i].isEmpty() && !posB[i].isEmpty()) {
                int pa = posA[i].first();
                int pb = posB[i].first();

                if (ra - pa + 1 + rb - lb + 1 >= k && ra - la + 1 + rb - pb + 1 >= k) {
                    LinkedList<Integer> ans1 = work(A, pa + 1, ra, B, lb, rb, k - 1);
                    LinkedList<Integer> ans2 = work(A, la, ra, B, pb + 1, rb, k - 1);

                    LinkedList<Integer> ans = ans1;

                    for (int j = 0; j < ans1.size(); j++) {
                        if (ans1.get(j) < ans2.get(j)) {
                            ans = ans2;
                            break;
                        } else if (ans1.get(j) > ans2.get(j)) {
                            break;
                        }
                    }

                    ans.addFirst(i);
                    return ans;
                } else if (ra - pa + 1 + rb - lb + 1 >= k) {
                    LinkedList<Integer> ans1 = work(A, pa + 1, ra, B, lb, rb, k - 1);
                    ans1.addFirst(i);
                    return ans1;
                } else if (ra - la + 1 + rb - pb + 1 >= k) {
                    LinkedList<Integer> ans2 = work(A, la, ra, B, pb + 1, rb, k - 1);
                    ans2.addFirst(i);
                    return ans2;
                }

            } else if (!posA[i].isEmpty()) {
                int pa = posA[i].first();
                if (ra - pa + 1 + rb - lb + 1 >= k) {
                    LinkedList<Integer> ans1 = work(A, pa + 1, ra, B, lb, rb, k - 1);
                    ans1.addFirst(i);
                    return ans1;
                }
            } else if (!posB[i].isEmpty()) {
                int pb = posB[i].first();
                if (ra - la + 1 + rb - pb + 1 >= k) {
                    LinkedList<Integer> ans2 = work(A, la, ra, B, pb + 1, rb, k - 1);
                    ans2.addFirst(i);
                    return ans2;
                }
            }
        }

        return null;

    }

    public static void main(String[] args) {

        System.out.println(new P321_CreateMaximumNumber().maxNumber(
                new int[]{6,4,7,8,6,5,5,3,1,7,4,9,9,5,9,6,1,7,1,3,6,3,0,8,2,1,8,0,0,7,3,9,3,1,3,7,5,9,4,3,5,8,1,9,5,6,5,7,8,6,6,2,0,9,7,1,2,1,7,0,6,8,5,8,1,6,1,5,8,4},
                new int[]{3,0,0,1,4,3,4,0,8,5,9,1,5,9,4,4,4,8,0,5,5,8,4,9,8,3,1,3,4,8,9,4,9,9,6,6,2,8,9,0,8,0,0,0,1,4,8,9,7,6,2,1,8,7,0,6,4,1,8,1,3,2,4,5,7,7,0,4,8,4},
                70));
//        System.out.println(new P321_CreateMaximumNumber().maxNumber(
//                new int[]{6, 7, 5},
//                new int[]{4, 8, 1},
//                3));
//        System.out.println(new P321_CreateMaximumNumber().maxNumber(
//                new int[]{3, 9},
//                new int[]{8, 9},
//                3));
//        System.out.println(new P321_CreateMaximumNumber().maxNumber(
//                new int[]{6, 7},
//                new int[]{6, 0, 4},
//                5));
//        System.out.println(new P321_CreateMaximumNumber().maxNumber(
//                new int[]{3, 4, 6, 5},
//                new int[]{9, 1, 2, 5, 8, 3},
//                5));
    }

}
