package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoyuan on 24/09/2017.
 */
public class P681_NextClosestTime {

    Set<Character> set;
    char[] now;

    String TIME;
    String ans;
    int dist;
    public String nextClosestTime(String time) {

        TIME = time;
        dist = Integer.MAX_VALUE;

        now = new char[5];
        set = new HashSet<>();
        for (char ch : time.toCharArray()) {
            if (ch != ':') set.add(ch);
        }


        dfs(0);

        return ans;
    }

    private void dfs(int d) {
        if (d == 4) {
//            for (int i = 0; i < 4; i++) {
//                System.out.print(now[i] + " ");
//            }
//            System.out.println();


            if (okay()) {
                int dis = getDis();
                if (dis < dist) {
                    dist = dis;
                    ans = "" + now[0] + now[1] + ":" + now[2] + now[3];
                }
            }

            return;
        }

        for (char ch : set) {
            now[d] = ch;
            dfs(d + 1);
        }
    }

    public int getDis() {
        int hour = Integer.parseInt("" + now[0] + "" +  now[1]);
        int min = Integer.parseInt("" + now[2] + "" + now[3]);


        int H = Integer.parseInt(TIME.substring(0, 2));
        int M = Integer.parseInt(TIME.substring(3));

        if (hour > H || (hour == H && min > M)) {
            return hour * 60 + min - H * 60 + H;
        } else {
            return 24 * 60 + hour * 60 + min - H * 60 + H;
        }


    }
    private boolean okay() {
        int hour = Integer.parseInt(now[0] + "" +  now[1]);
        int min = Integer.parseInt(now[2] + "" + now[3]);

        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }

    public static void main(String[] args) {
        System.out.println(new P681_NextClosestTime().nextClosestTime("19:34"));
        System.out.println(new P681_NextClosestTime().nextClosestTime("23:59"));
    }

}
