package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiaoyuan on 13/04/2017.
 */
public class P251_Flatten2DVector {

    public static void main(String[] args) {

        List<List<Integer>> vect = new ArrayList<>();
        vect.add(Arrays.asList(1, 2));
        vect.add(Arrays.asList(3));
        vect.add(Arrays.asList(4, 5));
        Vector2D obj = new Vector2D(vect);

        while (obj.hasNext()) {
            System.out.println(obj.next());
        }

    }

}


class Vector2D implements Iterator<Integer> {

    int m;
    int n;
    private List<List<Integer>> vect;

    public Vector2D(List<List<Integer>> vec2d) {
        vect = vec2d;

        m = 0;
        n = 0;

        for(; m < vect.size(); m++) {
            if (n < vect.get(m).size()) {
                break;
            }
        }
    }

    @Override
    public Integer next() {
        int a = vect.get(m).get(n);

        n ++;
        for(; m < vect.size(); m++,n=0) {
            if (n < vect.get(m).size()) {
                break;
            }
        }
        return a;
    }

    @Override
    public boolean hasNext() {
        return m < vect.size() && n < vect.get(m).size();
    }
}