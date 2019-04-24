package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 18/04/2017.
 */

class ZigzagIterator {

    List<Integer> A;
    List<Integer> B;
    int a;
    int b;
    int z;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        A = v1;
        B = v2;

        a = 0;
        b = 0;
        z = 0;
    }

    public int next() {
        if (!hasNext()) return -1;
        if (z == 0 && a == A.size()) z = 1;
        if (z == 1 && b == B.size()) z = 0;

        int val = -1;
        if (z == 0) {
            val = A.get(a);
            a++;
        } else {
            val = B.get(b);
            b++;
        }
        z = 1 - z;

        return val;
    }

    public boolean hasNext() {
        return !(a == A.size() && b == B.size());
    }
}
public class P281_ZigzagIterator {


    public static void main(String[] args) {

    }

}


