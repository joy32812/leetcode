package com.leetcode;

/**
 * Created by xiaoyuan on 04/06/2017.
 */
public class P418_SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";

        int pos = 0;
        int len = s.length();
        for (int i = 0; i < rows; i++) {
            pos += cols;

            if (s.charAt(pos % len) == ' ') pos ++;
            else {
                while (pos - 1 >= 0 && s.charAt((pos - 1) % len) != ' ') pos --;
            }

        }

        return pos / len;
    }

    public static void main(String[] args) {
//        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"A", "B", "C"}, 8, 7));
//        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"hello", "world"}, 2, 8));
//        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"Hello"}, 10000, 1));
        System.out.println(new P418_SentenceScreenFitting().wordsTyping(new String[]{"I", "had", "apple", "pie"}, 4, 5));
    }

}
