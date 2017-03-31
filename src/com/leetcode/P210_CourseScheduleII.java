package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 31/03/2017.
 */
public class P210_CourseScheduleII {

    Map<Integer, List<Integer>> needMap;
    int[] visit;
    List<Integer> ans;

    private boolean canLearn(int x) {
        visit[x] = 1;
        List<Integer> ajList = needMap.get(x);
        if (ajList == null) {
            visit[x] = 2;
            ans.add(x);
            return true;
        }

        for (int aj : ajList) {
            if (visit[aj] == 0) {
                if (!canLearn(aj)) {
                    return false;
                }
            } else if (visit[aj] == 1) {
                return false;
            }
        }

        visit[x] = 2;
        ans.add(x);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        needMap = new HashMap<Integer, List<Integer>>();
        visit = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            List<Integer> adjList = needMap.get(a);
            if (adjList == null) {
                adjList = new ArrayList<Integer>();
            }
            adjList.add(b);
            needMap.put(a, adjList);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if (!canLearn(i)) {
                    return false;
                }
            }
        }

        return true;

    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new ArrayList<Integer>();
        if (!canFinish(numCourses, prerequisites)) {
            return new int[]{};
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new P210_CourseScheduleII().findOrder(1, new int[][]{}));
    }

}
