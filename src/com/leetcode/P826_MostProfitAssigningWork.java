package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P826_MostProfitAssigningWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 0);

        List<int[]> valList = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            valList.add(new int[]{difficulty[i], profit[i]});
        }
        valList.sort((a, b) -> (a[0] - b[0]));

        int maxProfit = 0;
        for (int i = 0; i < valList.size(); i++) {
            int[] val = valList.get(i);
            maxProfit = Math.max(maxProfit, val[1]);
            treeMap.put(val[0], maxProfit);
        }

        int ans = 0;
        for (int work : worker) {
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(work);
            ans += entry.getValue();
        }

        return ans;
    }

}
