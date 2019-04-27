package com.leetcode;

public class P702_SearchinaSortedArrayofUnknownSize {

    interface ArrayReader {
        int get(int index);
    }
    public int search(ArrayReader reader, int target) {
        return binarySearch(reader, 0, -1, target);
    }

    private int binarySearch(ArrayReader reader, int l, int r, int target) {
        if (r == -1) {
            int mid = (l + 1) * 2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) > target) return binarySearch(reader, l, mid, target);

            return binarySearch(reader, mid, r, target);
        }

        while (l < r) {
            int mid = (l + r) / 2;
            if (reader.get(mid) == target) return mid;

            if (reader.get(mid) > target) r = mid;
            else l = mid + 1;
        }

        return -1;
    }

}
