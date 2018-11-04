package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P936_StampingTheSequence {


    /**
     * greedy algorithm
     * @param stamp
     * @param target
     * @return
     */
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> ans = new ArrayList<>();

        String aim = target.replaceAll("[a-z]", "?");

        while (!aim.equals(target)) {

            int v = remove(stamp, target);

            if (v == -1) return new int[]{};

            ans.add(v);

            target = target.substring(0, v) + aim.substring(0, stamp.length()) + target.substring(v + stamp.length());

        }

        Collections.reverse(ans);
        return ans.stream().mapToInt(x -> x).toArray();
    }

    private int remove(String stamp, String target) {

        String aim = stamp.replaceAll("[a-z]", "?");

        for (int i = 0; i <= target.length() - stamp.length(); i++) {
            if (target.substring(i, i + stamp.length()).equals(aim)) continue;

            boolean okay = true;
            for (int j = 0; j < stamp.length(); j++) {
                if (target.charAt(i + j) == '?') continue;
                if (target.charAt(i + j) == stamp.charAt(j)) continue;

                okay = false;
                break;
            }

            if (okay) return i;
        }

        return -1;
    }


    public static void main(String[] args) {

        int[] ans = new P936_StampingTheSequence().movesToStamp("abca", "aabcaca");

        System.out.println("yes");
    }

}
