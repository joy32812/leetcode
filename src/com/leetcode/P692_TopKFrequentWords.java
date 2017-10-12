package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 12/10/2017.
 */
public class P692_TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> cntMap = new HashMap<>();

        for (String w : words) {
            cntMap.put(w, cntMap.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int n1 = Integer.parseInt(o1[1]);
                int n2 = Integer.parseInt(o2[1]);
                if (n1 == n2) return o2[0].compareTo(o1[0]);
                return n1 - n2;
            }
        });

        for (String w : cntMap.keySet()) {
            pq.add(new String[]{w, "" + cntMap.get(w)});
            if (pq.size() > k) pq.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) ans.add(pq.poll()[0]);

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P692_TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new P692_TopKFrequentWords().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

}
