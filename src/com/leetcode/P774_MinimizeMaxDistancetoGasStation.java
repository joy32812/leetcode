package com.leetcode;

import java.util.Arrays;

public class P774_MinimizeMaxDistancetoGasStation {

    /**
     * binary search
     * @param stations
     * @param K
     * @return
     */
    public double minmaxGasDist(int[] stations, int K) {
        if (stations == null || stations.length <= 1) return 0;
        Arrays.sort(stations);

        double l = 0;
        double r = 1e8 + 1;

        while (r - l > 1e-6) {
            double mid = (l + r) / 2;
            if (okay(mid, stations, K)) r = mid;
            else l = mid;
        }

        return l;

    }

    private boolean okay(double dis, int[] stations, int k) {
        int total = 0;
        for (int i = 1; i < stations.length; i++) {
            double len = stations[i] - stations[i - 1];
            total += (int) ((len - 1e-6) / dis);
            if (total > k) return false;
        }

        return true;
    }

}
