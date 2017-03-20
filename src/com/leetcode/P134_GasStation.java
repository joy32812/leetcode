package com.leetcode;

/**
 * Created by xiaoyuan on 18/03/2017.
 */
public class P134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {return -1;}

        int ans = 0;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            sum += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                ans = i + 1;
            }
        }

        if (sum < 0) {return -1;}
        if (ans >= gas.length) {return -1;}

        return ans;
    }


    public static void main(String[] args) {

    }

}
