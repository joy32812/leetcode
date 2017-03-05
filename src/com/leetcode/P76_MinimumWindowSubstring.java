package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiaoyuan on 05/03/2017.
 * 1. use queue to remember the index of every char in t
 * 2. find the first one
 * 3. iterate the q to narrow down
 */

public class P76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() == 0) {return "";}

        int[] cntArray = new int[10000];
        for (int i = 0; i < t.length(); i++) {
            cntArray[t.charAt(i)]++;
        }

        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (cntArray[s.charAt(i)] > 0) {
                q.addLast(i);
            }
        }

        int cnt = t.length();
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (cntArray[s.charAt(i)] > 0) {
                cntArray[s.charAt(i)] --;
                cnt--;
                if (cnt == 0) {
                    begin = q.getFirst();
                    end = i;
                }
            } else {
                cntArray[s.charAt(i)] --;
            }

            if (cnt == 0) {
                while (!q.isEmpty() && cntArray[s.charAt(q.getFirst())] < 0){
                    if (i - q.get(1) < end - begin) {
                        begin = q.get(1);
                        end = i;
                    }
                    cntArray[s.charAt(q.getFirst())] ++;
                    q.removeFirst();
                }
            }
        }

        if (cnt > 0) {return "";}

        return s.substring(begin, end + 1);
    }

    public static void main(String[] args) {
//        System.out.println(new P76_MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(new P76_MinimumWindowSubstring().minWindow("A", "A"));
        System.out.println(new P76_MinimumWindowSubstring().minWindow("bba", "ab"));
    }

}
