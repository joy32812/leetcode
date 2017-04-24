package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 24/04/2017.
 */
public class P299_BullsandCows {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> sNumMap = new HashMap<>();
        Map<Character, Integer> gNumMap = new HashMap<>();

        int A = 0;

        for (int i = 0; i < secret.length(); i++) {
            char sCh = secret.charAt(i);
            char gCh = guess.charAt(i);

            if (sCh == gCh) {
                A++;
            } else {
                if (!sNumMap.containsKey(sCh)) {
                    sNumMap.put(sCh, 1);
                } else {
                    sNumMap.put(sCh, sNumMap.get(sCh) + 1);
                }

                if (!gNumMap.containsKey(gCh)) {
                    gNumMap.put(gCh, 1);
                } else {
                    gNumMap.put(gCh, gNumMap.get(gCh) + 1);
                }
            }
        }

        int B = 0;
        for (char ch : gNumMap.keySet()) {
            int gNum = gNumMap.get(ch);


            if (sNumMap.containsKey(ch)) {
                B += Math.min(gNum, sNumMap.get(ch));
            }

        }


        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        System.out.println(new P299_BullsandCows().getHint("1122", "2211"));
    }

}
