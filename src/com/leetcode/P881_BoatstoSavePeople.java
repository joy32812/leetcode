package com.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

public class P881_BoatstoSavePeople {

    /**
     * greedy
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats2(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;

        int ans = 0;
        while (l <= r) {
            ans ++;
            if (l == r) break;

            r --;
            if (people[l] + people[r] <= limit) l++;
        }

        return ans;
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int p : people) treeMap.put(p, treeMap.getOrDefault(p, 0) + 1);

        int ans = 0;
        for (int i = people.length - 1; i >= 0; i--) {
            int p = people[i];
            if (!treeMap.containsKey(p)) continue;
            ans ++;

            int need = limit;
            int cnt = 0;
            while (need > 0 && cnt < 2) {
                Integer other = treeMap.floorKey(need);
                if (other == null) break;
                need -= other;
                treeMap.put(other, treeMap.get(other) - 1);
                if (treeMap.get(other) == 0) treeMap.remove(other);

                cnt++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P881_BoatstoSavePeople().numRescueBoats(new int[]{3,2,3,2,2}, 6));
    }

}
