package com.leetcode;

public class P1006_ClumsyFactorial {


    int[] nums;


    /**
     * easy, make every 4th num negative, then sum all
     * @param N
     * @return
     */
    public int clumsy(int N) {


        long ans = 0;


        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = N - i;
            if (i != 0 && i % 4 == 0) nums[i] = -1 * nums[i];
        }

        int i = 0;
        while (i < N) {

            int now = getNow(i);
            ans += now;
            i = i + 4;

        }



        return (int) ans;


    }

    private int getNow(int i) {
        int n = nums.length;
        int a = nums[i];
        if (i + 1 == n) return a;

        a = a * nums[i + 1];
        if (i + 2 == n) return a;

        a = a / nums[i + 2];
        if (i + 3 == n) return a;

        return a + nums[i + 3];
    }


    public static void main(String[] args) {

        System.out.println(new P1006_ClumsyFactorial().clumsy(4));
        System.out.println(new P1006_ClumsyFactorial().clumsy(10));
    }

}
