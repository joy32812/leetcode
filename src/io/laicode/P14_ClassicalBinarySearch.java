package io.laicode;

import java.util.Arrays;

public class P14_ClassicalBinarySearch {

    public int binarySearch(int[] array, int target) {
        // Write your solution here

        int i = Arrays.binarySearch(array, target);
        if (i < 0) return -1;
        return i;
    }

}
