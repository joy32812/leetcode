package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 18/09/2017.
 */
public class P488_ZumaGame {

    private int L;
    private static final int THEMAX = 1842;
    private Map<String, Integer> ansMap;
    public int findMinStep(String board, String hand) {

        L = hand.length();
        ansMap = new HashMap<>();

        int v = dfs(board, hand);
        return v == THEMAX ? -1 : v;
    }

    private int dfs(String board, String hand) {
        String key = board + "_" + hand;
        if (ansMap.containsKey(key)) return ansMap.get(key);

        if (hand.length() == 0 && board.length() > 0) {
            ansMap.put(key, THEMAX);
            return ansMap.get(key);
        }

        if (board.length() == 0) {
            ansMap.put(key, L - hand.length());
            return ansMap.get(key);
        }

        int res = THEMAX;
        for (int i = 0; i < board.length(); i++) {
            char x = board.charAt(i);
            for (int j = 0; j < hand.length(); j++) {
                char y = hand.charAt(j);

                if (x != y) continue;

                res = Math.min(dfs(getNewBoard(board.substring(0, i) + board.charAt(i) + board.substring(i)), hand.substring(0, j) + hand.substring(j + 1)), res);
            }
        }
        ansMap.put(key, res);
        return res;
    }

    private String getNewBoard(String board) {
        if (board.length() == 0) return "";

        char lastCh = board.charAt(0);
        int cnt = 1;
        for (int i = 1; i < board.length(); i++) {
            if (board.charAt(i) != lastCh) {
                if (cnt >= 3) {
                    return getNewBoard(board.substring(0, i - cnt) + board.substring(i));
                }

                lastCh = board.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (cnt >= 3) {
            return getNewBoard(board.substring(0, board.length() - cnt));
        }


        return board;
    }

    public static void main(String[] args) {
//        System.out.println(new P488_ZumaGame().findMinStep("WRRBBW", "RB"));
//        System.out.println(new P488_ZumaGame().findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(new P488_ZumaGame().findMinStep("G", "GGGGG"));
        System.out.println(new P488_ZumaGame().findMinStep("RBYYBBRRB", "YRBGB"));
    }

}
