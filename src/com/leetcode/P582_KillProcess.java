package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P582_KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> childrenMap = new HashMap<>();

        for (int i = 0; i < pid.size(); i++) {
            int parentId = ppid.get(i);
            int childId = pid.get(i);
            childrenMap.computeIfAbsent(parentId, k -> new ArrayList<Integer>()).add(childId);
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        Q.add(kill);
        while (!Q.isEmpty()) {
            int father = Q.poll();
            ans.add(father);

            List<Integer> children = childrenMap.get(father);
            if (children != null) {
                for (int d : children) {
                    Q.add(d);
                }
            }
        }

        return ans;
    }

}
