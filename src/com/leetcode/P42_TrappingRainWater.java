package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyuan on 26/02/2017.
 * 排序找出课可能盛水的两个端点
 *
 * O(n*lgn)
 *
 */
public class P42_TrappingRainWater {

    private class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < height.length; i++) {
            nodeList.add(new Node(i, height[i]));
        }

        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value == o2.value) {
                    return o1.index - o2.index;
                }
                return o2.value - o1.value;
            }
        });


        List<Node> vips = new ArrayList<Node>();

        int left = -1;
        int right = -1;
        int pos = 0;
        while (pos < nodeList.size()) {
            int i = 0;
            for (i = pos + 1; i < nodeList.size(); i++) {
                if (nodeList.get(i).value != nodeList.get(pos).value) {
                    break;
                }
            }

            int l = pos;
            int r = i - 1;

            if (left == -1) {
                left = nodeList.get(l).index;
                right = nodeList.get(r).index;
                vips.add(nodeList.get(l));
                if (l != r) {
                    vips.add(nodeList.get(r));
                }
            } else {
                if (left > nodeList.get(l).index) {
                    left = nodeList.get(l).index;
                    vips.add(nodeList.get(l));
                }
                if (right < nodeList.get(r).index) {
                    right = nodeList.get(r).index;
                    vips.add(nodeList.get(r));
                }
            }

            pos = r + 1;
        }


        Collections.sort(vips, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.index - o2.index;
            }
        });

        int ans = 0;
        int l = 0;
        int r = 1;
        while (r < vips.size()) {
            int indexL = vips.get(l).index;
            int indexR = vips.get(r).index;
            int hh = Math.min(vips.get(l).value, vips.get(r).value);

            for (int i = indexL + 1; i < indexR; i++ ){
                ans += (hh - height[i]);
            }

            l ++;
            r ++;
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0};
        int[] nums2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(new P42_TrappingRainWater().trap(nums2));
    }

}
