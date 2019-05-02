package com.leetcode;

import java.util.Arrays;

public class P875_KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {

        int l = 0;
        int r = Arrays.stream(piles).max().getAsInt();

        while (l < r) {
            int mid = (l + r) / 2;

            if (okay(mid, piles, H)) r = mid;
            else l = mid + 1;
        }

        return l;
    }


    private boolean okay(int mid, int[] piles, int h) {
        if (mid == 0) return false;

        int cnt = 0;

        for (int p : piles) {
            cnt += (p / mid) + (p % mid > 0 ? 1 : 0);
            if (cnt > h) return false;
        }
        return true;
    }


}
