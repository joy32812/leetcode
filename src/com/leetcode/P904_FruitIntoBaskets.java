package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P904_FruitIntoBaskets {

    /**
     * sliding window
     * update the from pos
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {

        int ans = 0;

        int from = -1;
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < tree.length; i++) {
            if(posMap.size() == 2 && !posMap.containsKey(tree[i])) {
                int fruit = 0;
                int pos = Integer.MAX_VALUE;
                for (int f : posMap.keySet()) {
                    if (pos > posMap.get(f)) {
                        pos = posMap.get(f);
                        fruit = f;
                    }
                }
                from = pos;
                posMap.remove(fruit);
            }
            posMap.put(tree[i], i);

            ans = Math.max(ans, i - from);
        }

        return ans;
    }

}
