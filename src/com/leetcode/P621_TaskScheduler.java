package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P621_TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {return tasks.length;}

        int[] posArr = new int[26];
        int[][] charAndNum = new int[26][2];
        for (char ch : tasks) {
            charAndNum[ch - 'A'][0] = ch - 'A';
            charAndNum[ch - 'A'][1]++;
        }

        Arrays.fill(posArr, -1);
        int cnt = 0;
        while (true) {
            Arrays.sort(charAndNum, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return -(o1[1] - o2[1]);
                }
            });

            if (charAndNum[0][1] == 0) {break;}

            boolean find = false;
            for (int i = 0; i < 26; i++) {
                int task = charAndNum[i][0];
                if (charAndNum[i][1] == 0) {break;}

                if (posArr[task] == -1 || cnt - posArr[task] >= n) {
                    cnt++;
                    charAndNum[i][1]--;
                    find = true;
                    posArr[task] = cnt;
                    break;
                }
            }

            if (!find) {
                cnt++;
            }
        }


        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new P621_TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

}
