package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaoyuan on 08/10/2017.
 */
public class P691_StickerstoSpellWord {

    Map<Character, Integer>[] chCntMaps;
    Map<String, Integer> ansMap;
    public int minStickers(String[] stickers, String target) {

        Set<Character> dictSet = new HashSet<>();
        Set<Character> targetSet = new HashSet<>();

        for (String s : stickers) {
            for (char ch : s.toCharArray()) {
                dictSet.add(ch);
            }
        }

        for (char ch : target.toCharArray()) {
            targetSet.add(ch);
        }

        for (char ch : targetSet) {
            if (!dictSet.contains(ch)) return -1;
        }



        chCntMaps = new Map[stickers.length];
        for (int i = 0; i < stickers.length; i++) {
            String s = stickers[i];
            chCntMaps[i] = new HashMap<>();

            for (char ch : s.toCharArray()) {
                chCntMaps[i].put(ch, chCntMaps[i].getOrDefault(ch, 0) + 1);
            }
        }

        ansMap = new HashMap<>();
        return dfs(stickers, target);

    }

    private int dfs(String[] stickers, String target) {
        if (ansMap.containsKey(target)) return ansMap.get(target);
        if (target.length() == 0) return 0;

        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            StringBuilder sb = new StringBuilder();

            Map<Character, Integer> nowMap = chCntMaps[i];
            for (char ch : cntMap.keySet()) {
                int v = cntMap.get(ch);

                if (nowMap.containsKey(ch)) v -= nowMap.get(ch);
                if (v < 0) v = 0;

                for (int j = 0; j < v; j++) sb.append(ch);
            }

            if (target.equals(sb.toString())) continue;

            ans = Math.min(ans, 1 + dfs(stickers, sb.toString()));
        }

        ansMap.put(target, ans);
        return ansMap.get(target);
    }

    public static void main(String[] args) {
        System.out.println(new P691_StickerstoSpellWord().minStickers(new String[]{"notice", "possible"}, "basicbasic"));
        System.out.println(new P691_StickerstoSpellWord().minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }

}
