package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class P961_N_RepeatedElementinSize2NArray {



    public int repeatedNTimes(int[] A) {
        return Arrays.stream(A).filter(k -> Collections.frequency(Arrays.stream(A).boxed().collect(Collectors.toList()), k) > 1).findFirst().getAsInt();
    }


    public int repeatedNTimes2(int[] A) {

        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a)) return a;
            set.add(a);
        }

        return 0;
    }




    public static void main(String[] args) {

    }

}
