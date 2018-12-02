package com.leetcode;

import java.util.*;

public class P952_LargestComponentSizebyCommonFactor {

    public int largestComponentSize(int[] A) {
        if (A.length <= 1) return A.length;

        Set<Integer> numberSet = new HashSet<>();
        for (int a : A) {
            numberSet.add(a);
        }


        int maxNum = 100001;
        boolean[] prime = new boolean[maxNum];
        int[] father = new int[maxNum];
        int[] minPrim = new int[maxNum];

        Map<Integer, Set<Integer>> primMap = new HashMap<>();

        Arrays.fill(father, -1);
        Arrays.fill(minPrim, -1);

        for (int i = 2 ; i < maxNum; i++) {
            if (prime[i]) continue;

//            System.out.println("i: " + i);
            prime[i] = true;
            father[i] = i;

            for (int j = i; j < maxNum; j += i) {
                prime[j] = true;
//                System.out.println("j: " + j);
                if (numberSet.contains(j)) {

                    Set<Integer> nowSet = primMap.computeIfAbsent(j, k -> new HashSet<>());
                    nowSet.add(i);
//                    int f = Integer.MAX_VALUE;
//                    for (int n : nowSet) {
//                        f = Math.min(f, getFather(father, n));
//                    }
//                    for (int n : nowSet) {
//                        father[n] = f;
//                    }

//                    if (minPrim[j] == -1) minPrim[j] = i;
//                    if (father[i] > minPrim[j] && minPrim[j] != -1) {
//                        father[i] = minPrim[j];
//                    }

                    if (father[j] == -1) father[j] = i;
//                    father[j] = i;
//                    father[j] = getFather(father, j);
                }
            }
        }




        Map<Integer, Integer> ansMap = new HashMap<>();
        for (int a : A) {
            Set<Integer> nowSet = primMap.computeIfAbsent(a, k -> new HashSet<>());
            int f = Integer.MAX_VALUE;
            for (int n : nowSet) {
                f = Math.min(f, getFather(father, n));
            }
            for (int n : nowSet) {
                father[n] = f;
            }
        }
        for (int a : A) {
            Set<Integer> nowSet = primMap.computeIfAbsent(a, k -> new HashSet<>());
            int f = Integer.MAX_VALUE;
            for (int n : nowSet) {
                f = Math.min(f, getFather(father, n));
            }
            for (int n : nowSet) {
                father[n] = f;
            }
        }
        for (int a : A) {
            int f = getFather(father, a);
            ansMap.put(f, ansMap.getOrDefault(f, 0) + 1);
        }

        int ans = 0;
        for (int v : ansMap.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }

    private int getFather(int[] father, int x) {
        while (father[x] != -1 && father[x] != x) x = father[x];
        return x;
    }


    public static void main(String[] args) {
//        System.out.println(new AA1().largestComponentSize(new int[]{4, 6, 15, 35}));
//        System.out.println(new AA1().largestComponentSize(new int[]{98,39,14,86,56,89,26,59,63}));
//        System.out.println(new AA1().largestComponentSize(new int[]{2,3,6,7,4,12,21,39}));
//        System.out.println(new AA1().largestComponentSize(new int[]{20, 50, 9, 63}));
        System.out.println(new P952_LargestComponentSizebyCommonFactor().largestComponentSize(new int[]{99,68,70,77,35,52,53,25,62}));
//        System.out.println(new AA1().largestComponentSize(new int[]{65,35,43,76,15,11,81,22,55,92,31}));
    }

}
