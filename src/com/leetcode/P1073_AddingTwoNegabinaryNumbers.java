package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P1073_AddingTwoNegabinaryNumbers {


    /**
     * basic idea: 2 * A[j - 1] + A[j] == 0
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] addNegabinary(int[] arr1, int[] arr2) {

        List<Integer> A = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> B = Arrays.stream(arr2).boxed().collect(Collectors.toList());

        Collections.reverse(A);
        Collections.reverse(B);

        for (int i = 0; i < 1000; i++) {
            A.add(0);
            B.add(0);
        }


        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < A.size() || j < B.size()) {
            int now = (i < A.size() ? A.get(i) : 0) + (j < B.size() ? B.get(j) : 0);
            int next = (i + 1 < A.size() ? A.get(i + 1) : 0) + (j + 1 < B.size() ? B.get(j + 1) : 0);

            while (now >= 2 && next > 0) {
                now -= 2;
                next --;

                if (i + 1 < A.size() && A.get(i + 1) > 0) {
                    A.set(i + 1, A.get(i + 1) - 1);
                } else if (j + 1 < B.size() && B.get(j + 1) > 0) {
                    B.set(j + 1, B.get(j + 1) - 1);
                }
            }

            while (now >= 2) {
                now -= 2;
                A.set(i + 1, A.get(i + 1) + 1);
                A.set(i + 2, A.get(i + 2) + 1);
            }
            if (now <= 1) ans.add(now);

            i++;
            j++;
        }

        int pos = 0;
        for (int k = ans.size() - 1; k >= 0; k --) {
            if (ans.get(k) != 0) {
                pos = k;
                break;
            }
        }

        int id = 0;
        int[] ret = new int[pos + 1];
        for (int k = pos; k >= 0; k--) ret[id++] = ans.get(k);

        return ret;
    }


}
