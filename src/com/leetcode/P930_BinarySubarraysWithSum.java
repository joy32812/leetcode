package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P930_BinarySubarraysWithSum {


    /**
     * count by first element, count the number '0' after S '1'
     * @param A
     * @param S
     * @return
     */
    public int numSubarraysWithSum(int[] A, int S) {

        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) continue;
            ones.add(i);
        }
        ones.add(A.length);


        if (S > ones.size() - 1) return 0;

        int ans = 0;
        int cntOne = 0;
        for (int i = 0; i < A.length; i++) {

            int p, q;
            if (S == 0) {
                p = i;
                if (cntOne >= ones.size()) continue;
                q = ones.get(cntOne);
            } else {
                if (S + cntOne >= ones.size()) break;
                p = ones.get(S + cntOne - 1);
                q = ones.get(S + cntOne);
            }

            if (A[i] == 1) cntOne ++;
            if (S == 0 && A[i] == 1) continue;
            if (q > A.length) break;


            ans += (q - p);
        }

        return ans;
    }

    /**
     * this is is much more elegant, much more easy to implement
     * just count occurrence of all prefix sum
     * @param A
     * @param S
     * @return
     */
    public int numSubarraysWithSum2(int[] A, int S) {
        Map<Integer, Integer> c = new HashMap<>();
        c.put(0, 1);
        int psum = 0, res = 0;
        for (int i : A) {
            psum += i;
            res += c.getOrDefault(psum - S, 0);
            c.put(psum, c.getOrDefault(psum, 0)+1);
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(new P930_BinarySubarraysWithSum().numSubarraysWithSum2(new int[]{1,0,1,0,1}, 2));

    }

}
