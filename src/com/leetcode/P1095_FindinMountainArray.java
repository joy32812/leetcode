package com.leetcode;


interface MountainArray {
    int get(int index);
    int length();
}

public class P1095_FindinMountainArray {

    /**
     * 1. get peak
     * 2. check if in either one of them
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = getPeak(mountainArr);

        int last = bs(target, mountainArr, 0, peak, true);
        if (last != -1) return last;

        return bs(target, mountainArr, peak, mountainArr.length() - 1, false);
    }

    private int bs(int target, MountainArray mountainArr, int l, int r, boolean asc) {
        if (mountainArr.get(l) == target) return l;
        if (mountainArr.get(r) == target) return r;

        while (l < r) {
            int m = (l + r) / 2;
            if (mountainArr.get(m) == target) return m;

            if (asc) {
                if (mountainArr.get(m) > target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (mountainArr.get(m) < target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    private int getPeak(MountainArray mountainArr) {
        int len = mountainArr.length();

        int l = 0;
        int r = len - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (mountainArr.get(m) > mountainArr.get(m + 1)) r = m;
            else l = m + 1;
        }
        return l;
    }

}
