package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiaoyuan on 18/04/2017.
 */
public class P281_ZigzagIterator {

    int round;
    int now;
    private LinkedList<List<Integer>> allList;
    public P281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        allList = new LinkedList<>();
        round = 0;
        now = 0;

        if (v1.size() > 0) {allList.add(v1);}
        if (v2.size() > 0) {allList.add(v2);}
    }

    public int next() {
        int value = allList.get(now).get(round);
        if (round == allList.get(now).size() - 1) {
            allList.remove(now);
            now--;
        }

        now++;
        if (now >= allList.size()) {
            now = 0;
            round ++;
        }

        return value;
    }

    public boolean hasNext() {
        return allList.size() > 0;
    }


    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<>();
        v1.add(1);
        v1.add(2);

        List<Integer> v2 = new ArrayList<>();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);

        P281_ZigzagIterator obj = new P281_ZigzagIterator(v1, v2);
        while (obj.hasNext()) {
            int v = obj.next();
            System.out.println(v);
        }

    }

}


