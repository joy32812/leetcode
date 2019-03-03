package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P1000_MinimumCosttoMergeStones {


    // TODO
    public int mergeStones(int[] stones, int K) {
        int N = stones.length;
        if ((N - K) % (K-1) != 0) return -1;



        return 0;
    }



    public static void main(String[] args) {

        System.out.println(new P1000_MinimumCosttoMergeStones().mergeStones(new int[]{69,39,79,78,16,6,36,97,79,27,14,31,4}, 2));

    }

}
