package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1104_PathInZigzagLabelledBinaryTree {

    /**
     * use /2 technic to find normal path
     * the find the proper label reversely
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {

        List<Integer> ans = new ArrayList<>();
        while (label >= 1) {
            ans.add(label);
            label /= 2;
        }



        int l = 1;
        int r = 1;
        for (int i = 1; i < ans.size(); i++) {
            l = l * 2;
            r = r * 2 + 1;
        }

        for (int i = 1; i < ans.size(); i++) {

            l = l / 2;
            r = r / 2;

            if (i % 2 == 0) continue;
            ans.set(i, r - ans.get(i) + l);
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P1104_PathInZigzagLabelledBinaryTree().pathInZigZagTree(14));
        System.out.println(new P1104_PathInZigzagLabelledBinaryTree().pathInZigZagTree(26));
    }
}
