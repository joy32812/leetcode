package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiaoyuan on 14/08/2017.
 */
public class P658_FindKClosestElements {

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

        int n = arr.size();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = arr.get(i);
        }

        int l = 0;
        int r = 1;
        if (x < data[0]) {
            l = 0;
            r = 1;
        } else if (x > data[n - 1]) {
            l = n - 2;
            r = n - 1;
        } else {
            for (int i = 0; i < n; i++) {
                if (data[i] >= x) {
                    l = i - 1;
                    r = i;
                    break;
                }
            }
        }


        List<Integer> ans = new ArrayList<>();
        while (ans.size() < k) {
            if (l < 0) {
                ans.add(data[r]);
                r++;
            } else if (r >= n) {
                ans.add(data[l]);
                l--;
            } else if(Math.abs(data[l] - x) <= Math.abs(data[r] - x)) {
                ans.add(data[l]);
                l--;
            } else {
                ans.add(data[r]);
                r++;
            }
        }

        ans.sort((a, b) -> (a - b));
        return ans;
    }


    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(3);
//        list.add(4);
//        list.add(7);
//        list.add(7);
//        list.add(8);
//        System.out.println(new P658_FindKClosestElements().findClosestElements(list, 3, 5));

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(8);
        System.out.println(new P658_FindKClosestElements().findClosestElements(list, 2, 2));
    }

}
