package com.leetcode;

/**
 * Created by xiaoyuan on 23/09/2017.
 */
public class P517_SuperWashingMachines {

    int avg;
    public int findMinMoves(int[] machines) {

        int n = machines.length;
        int sum = 0;
        for (int d : machines) sum += d;

        if (sum % n != 0) return -1;
        avg = sum / n;


        int ans = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int now = machines[i] - avg;
            total += now;

            ans = Math.max(ans, now);
            ans = Math.max(ans, Math.abs(total));
        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(new P517_SuperWashingMachines().findMinMoves(new int[]{9, 1, 8, 8, 9}));
//        System.out.println(new P517_SuperWashingMachines().findMinMoves(new int[]{100000,0,100000,0,100000,0,100000,0,100000,0,100000,0}));
//        System.out.println(new P517_SuperWashingMachines().findMinMoves(new int[]{1, 0, 5}));
//        System.out.println(new P517_SuperWashingMachines().findMinMoves(new int[]{0, 3, 0}));
//        System.out.println(new P517_SuperWashingMachines().findMinMoves(new int[]{0, 2, 0}));
//        System.out.println(new P517_SuperWashingMachines().findMinMoves(new int[]{10, 0, 0, 0, 10}));
//        System.out.println(new P517_SuperWashingMachines().findMinMoves(new int[]{7, 2, 1, 2, 8}));
    }

}
