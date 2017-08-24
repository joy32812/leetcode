package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 24/08/2017.
 */
public class P358_RearrangeStringkDistanceApart {

    private class CharNode {
        char ch;
        int lastPos;
        int num;

        public CharNode(char ch, int lastPos, int num) {
            this.ch = ch;
            this.lastPos = lastPos;
            this.num = num;
        }
    }

    public String rearrangeString(String s, int k) {

        Map<Character, Integer> numMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            numMap.put(ch, numMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<CharNode> pq = new PriorityQueue<>((a, b) -> {
            if (a.num != b.num) {return b.num - a.num;}

            if (a.lastPos != b.lastPos) {return a.lastPos - b.lastPos;}

            return a.ch - b.ch;
        });
        for (char ch : numMap.keySet()) {
            pq.add(new CharNode(ch, -1000000, numMap.get(ch)));
        }

        StringBuilder ans = new StringBuilder();

        int index = 0;
        while (!pq.isEmpty()) {
            List<CharNode> list = new ArrayList<>();

            boolean find = false;
            while (!pq.isEmpty()) {
                CharNode cn = pq.poll();

                if (index - cn.lastPos >= k) {
                    ans.append(cn.ch);
                    cn.num--;
                    cn.lastPos = index;
                    index++;
                    find = true;

                    if (cn.num > 0) {
                        pq.add(cn);
                    }
                    break;
                } else {
                    list.add(cn);
                }
            }

            pq.addAll(list);
            if (!find) {return "";}
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P358_RearrangeStringkDistanceApart().rearrangeString("aaadbbcc", 2));
        System.out.println(new P358_RearrangeStringkDistanceApart().rearrangeString("aaabc", 3));
        System.out.println(new P358_RearrangeStringkDistanceApart().rearrangeString("aaabbcc", 3));
    }

}
