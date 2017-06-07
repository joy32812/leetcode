package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 07/06/2017.
 */
public class P444_SequenceReconstruction {

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        int n = org.length;
        Map<Integer, Set<Integer>> fromMap = new HashMap<>();
        Map<Integer, Set<Integer>> toMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            fromMap.put(i, new HashSet<>());
            toMap.put(i, new HashSet<>());
        }

        boolean empty = true;
        for (List<Integer> seq : seqs) {
            if (seq.size() > 0) {empty = false;}
            for (int j = 0; j < seq.size(); j++) {
                if (seq.get(j) < 1 || seq.get(j) > n) {return false;}
            }
            for (int j = 1; j < seq.size(); j++) {
                toMap.get(seq.get(j - 1)).add(seq.get(j));
                fromMap.get(seq.get(j)).add(seq.get(j - 1));
            }
        }

        if (empty) {return false;}

        int from = -1;
        for (int i = 1; i <= n; i++) {
            if (fromMap.get(i).size() == 0) {
                if (from != -1) {return false;}
                from = i;
                fromMap.remove(from);
            }
        }

        if (from != org[0]) {return false;}

        for (int i = 1; i < n; i++) {
            int should = org[i];

            int newFrom = -1;
            Set<Integer> toSet = toMap.get(from);
            for (int to : toSet) {
                fromMap.get(to).remove(from);
                if (fromMap.get(to).size() == 0) {
                    if (newFrom != -1) {return false;}
                    newFrom = to;
                    fromMap.remove(newFrom);
                }
            }
            from = newFrom;
            if (from != should) {return false;}
        }



        return true;
    }


    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l.add(l3);

        System.out.println(new P444_SequenceReconstruction().sequenceReconstruction(new int[]{1}, l));
    }


}
