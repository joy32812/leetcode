package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiaoyuan on 06/08/2017.
 */
public class P636_ExclusiveTimeofFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];

        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            String[] logArr = log.split(":");

            int fid = Integer.parseInt(logArr[0]);
            boolean isStart = logArr[1].equals("start");
            int time = Integer.parseInt(logArr[2]);

            if (isStart) {
                if (!stack.isEmpty()) {
                    String now = stack.pop();
                    String[] nowArr = now.split("_");
                    int nfid = Integer.parseInt(nowArr[0]);
                    int ntime = Integer.parseInt(nowArr[1]);
                    ans[nfid] += time - ntime;

                    stack.add(nfid + "_" + time);
                }

                stack.add(fid + "_" + time);
            } else {
                String now = stack.pop();
                String[] nowArr = now.split("_");
                int nfid = Integer.parseInt(nowArr[0]);
                int ntime = Integer.parseInt(nowArr[1]);

                ans[nfid] += time + 1 - ntime;


                if (!stack.isEmpty()) {
                    now = stack.pop();
                    nowArr = now.split("_");
                    nfid = Integer.parseInt(nowArr[0]);

                    stack.add(nfid + "_" + (time + 1));
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("0:start:0");
        list.add("0:start:2");
        list.add("0:end:5");
        list.add("0:start:6");
        list.add("0:end:6");
        list.add("0:end:7");
        System.out.println(new P636_ExclusiveTimeofFunctions().exclusiveTime(1,  list));

    }

}
