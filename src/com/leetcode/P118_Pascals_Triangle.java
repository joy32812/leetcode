package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 13/03/2017.
 */
public class P118_Pascals_Triangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 1; i <= numRows; i++) {
            result.add(pascalAtK(i));
        }

        return result;
    }

    private List<Integer> pascalAtK(int k) {
        List<Integer> tmp = new ArrayList<Integer>();
        k--;

        tmp.add(1);

        long ai = k;
        long bi = 1;
        long now = ai / bi;

        for (int i = 1; i <= k; i++) {
            tmp.add((int)now);
            ai --;
            bi ++;

            now = now * ai / bi;
        }
        return tmp;
    }

    public static void main(String[] args) {

    }

}
