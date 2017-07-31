package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyuan on 31/07/2017.
 */
public class P649_Dota2Senate {

    public String predictPartyVictory(String senate) {

        Queue<Integer> M = new LinkedList<>();
        Queue<Integer> N = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {M.add(i);}
            else {N.add(i);}
        }

        while (!M.isEmpty() && !N.isEmpty()) {
            int a = M.poll();
            int b = N.poll();

            if (a < b) {
                M.add(a + n);
            } else {
                N.add(b + n);
            }
        }

        return M.size() > N.size() ? "Radiant" : "Dire";

    }


    public static void main(String[] args) {

//        System.out.println(new P649_Dota2Senate().predictPartyVictory("DDDDRRDDDRDRDRRDDRDDDRDRRRRDRRRRRDRDDRDDRRDDRRRDDRRRDDDDRRRRRRRDDRRRDDRDDDRRRDRDDRDDDRRDRRDRRRDRDRDR"));
        System.out.println(new P649_Dota2Senate().predictPartyVictory("DDDRDRRDRRDRDRRRDDRRDDDRDRDDDRRRRDDDDRDRRRRDRRRDRDRDDRDRRRRDRDRRRDRDDDRRDDDRDRDRDRRDRDDRDDRDDDDRDRRR"));
//        System.out.println(new P649_Dota2Senate().predictPartyVictory("RRDDD"));
//        System.out.println(new P649_Dota2Senate().predictPartyVictory("DDRRRR"));
//        System.out.println(new P649_Dota2Senate().predictPartyVictory("RD"));
//        System.out.println(new P649_Dota2Senate().predictPartyVictory("RDD"));

    }

}
