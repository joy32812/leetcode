package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 31/08/2017.
 */
public class P425_WordSquares {

    Map<String, List<String>> prefixMap;
    List<List<String>> ans;
    String[] now;
    public List<List<String>> wordSquares(String[] words) {

        now = new String[10];
        ans = new ArrayList<>();

        prefixMap = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                sb.append(ch);

                String key = len + sb.toString();
                prefixMap.computeIfAbsent(key, k -> new ArrayList<String>()).add(word);
            }
        }

        for (String word : words) {
            now[0] = word;
            work(1);
        }

        return ans;
    }

    private void work(int d) {
        int L = now[0].length();
        if (d >= L) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < L; i++) {
                tmp.add(now[i]);
            }
            ans.add(tmp);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d; i++) {
            sb.append(now[i].charAt(d));
        }

        String key = L + sb.toString();
        List<String> cands = prefixMap.get(key);
        if (cands != null && cands.size() > 0) {
            for (String word : cands) {
                now[d] = word;
                work(d + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new P425_WordSquares().wordSquares(new String[]{
                "area", "lead", "wall", "lady", "ball"
        }));
    }

}
