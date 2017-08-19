package com.leetcode;

/**
 * Created by xiaoyuan on 19/08/2017.
 */
public class P660_Remove9 {

    int N = 15;
    long[] total = new long[N];
    long[] nums = new long[N];

    int ans = 0;
    public int newInteger(int n) {

        nums[1] = 9;
        total[1] = 9;
        for (int i = 2; i < N; i++) {
            nums[i] = total[i - 1] * 8;
            total[i] = total[i - 1] + nums[i];
        }

        ans = 0;
        work(n + 1);

        return ans;
    }

    private void work(long n) {
        if (n < 10) {
            ans += get(1, (int)n - 1);
            return;
        }
        int j = -1;
        for (int i = 1; i < N; i++) {
            if (total[i] >= n) {
                j = i;
                break;
            }
        }

        long base = total[j - 1];
        long now = total[j - 1];
        int z = -1;
        for (int i = 1; i <= 9; i++) {
            now += base;
            if (now >= n) {
                z = i;
                break;
            }
        }
        ans += get(j, z);

        now -= base;
        work(n - now);

    }

    private int get(int d, int x) {
        return  (int)(x * Math.pow(10, d - 1));
    }

    public static void main(String[] args) {

        System.out.println(new P660_Remove9().newInteger(11000));
//        System.out.println(new P660_Remove9().newInteger(600));
//        System.out.println(new P660_Remove9().newInteger(729));
//        System.out.println(new P660_Remove9().newInteger(80));
//        System.out.println(new P660_Remove9().newInteger(9));
//        System.out.println(new P660_Remove9().newInteger(10));
//        System.out.println(new P660_Remove9().newInteger(123244));
    }

}
