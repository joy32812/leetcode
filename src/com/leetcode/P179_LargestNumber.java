package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 28/03/2017.
 * ZERO, ZERO, ZERO
 */
public class P179_LargestNumber {

    public String largestNumber(int[] nums) {

        List<Integer> numList = new ArrayList<Integer>();
        for (int d : nums) {numList.add(d);}

        Collections.sort(numList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = "" + o1;
                String b = "" + o2;

                int i = 0, j = 0;
                while (true) {
                    if (i == a.length() && j == b.length()) {return 0;}

                    if (i == a.length()) {
                        i = 0;
                        continue;
                    }
                    if (j == b.length()) {
                        j = 0;
                        continue;
                    }

                    char ca = a.charAt(i);
                    char cb = b.charAt(j);
                    if (ca < cb) {
                        return 1;
                    } else if (ca > cb) {
                        return -1;
                    } else {
                        i ++;
                        j ++;
                    }
                }
            }
        });


        StringBuilder sb = new StringBuilder();
        for (int d : numList) {
            sb.append(d);
        }

        int index = 0;
        while (index < sb.length() - 1 && sb.charAt(index) == '0') {
            index++;
        }

        return sb.substring(index);
    }

    public static void main(String[] args) {
        System.out.println(new P179_LargestNumber().largestNumber(new int[]{0, 0, 0}));
        System.out.println(new P179_LargestNumber().largestNumber(new int[]{0, 0}));
        System.out.println(new P179_LargestNumber().largestNumber(new int[]{0, 20, 104, 10425, 9}));
        System.out.println(new P179_LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

}
