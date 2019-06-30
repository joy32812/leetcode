package com.leetcode;

public class P1103_DistributeCandiestoPeople {


    /**
     * easy
     * n is small, so brute force is working
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        if (n == 1) return new int[]{candies};


        int[] ans = new int[n];

        int now = 1;
        int i = 0;
        while (true) {
            if (now >= candies) {
                ans[i] += candies;
                break;
            }

            ans[i] += now;
            candies -= now;

            now ++;
            i = (i + 1) % n;
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new P1103_DistributeCandiestoPeople().distributeCandies(1000000000, 2));
    }
}
