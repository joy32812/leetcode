package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 04/06/2017.
 */
public class P418_SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {

        int total = 0;
        for (String word : sentence) {total += word.length() + 1;}
        total--;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < sentence.length; i++) {
            int cnt = cols / (total + 1);
            int left = cols % (total + 1);

            if (left >= total) {
                cnt++;
                left -= total;

                if (cnt > 0) {left--;}
            }


            int j = i;
            int tmp = 0;
            while (true) {
                tmp += sentence[j].length() + (tmp > 0 ? 1 : 0);
                if (tmp > left) {
                    j = (j + sentence.length - 1) % sentence.length;
                    break;
                }
                j = (j + 1) % sentence.length;
                if (j == 0) {cnt++;}
            }

            list.add(new int[]{cnt, j});
        }

        int ans = 0;

        int a = 0;
        int b = 0;
        while (b < rows) {
            int[] range = list.get(a);
            ans += range[0];
            a = (range[1] + 1) % sentence.length;

            b++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"A", "B", "C"}, 8, 7));
//        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"hello", "world"}, 2, 8));
//        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
//        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"I"}, 2, 3));
//        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"I", "had", "apple", "pie"}, 4, 5));
    }

}
