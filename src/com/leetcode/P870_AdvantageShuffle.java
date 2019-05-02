package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P870_AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {

        List<int[]> data = new ArrayList<>();
        for (int i = 0; i < B.length; i++) data.add(new int[]{i, B[i], 0});

        Arrays.sort(A);
        data.sort(Comparator.comparingInt(a -> a[1]));

        int j = 0;
        int k = data.size() - 1;
        for (int i = 0; i < A.length; i++) {
            int[] db = data.get(j);

            if (A[i] > db[1]) {
                db[2] = A[i];
                j ++;
            }
            else {
                data.get(k)[2] = A[i];
                k --;
            }
        }


        data.sort(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < data.size(); i++) A[i] = data.get(i)[2];

        return A;
    }

}
