package com.leetcode;

/**
 * Created by xiaoyuan on 27/02/2017.
 */
public class P58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");

        if (array.length == 0) {
            return 0;
        }
        return array[array.length - 1].length();
    }

    public static void main(String[] args) {
        System.out.println(new P58_LengthOfLastWord().lengthOfLastWord("Hello, World"));
        System.out.println(new P58_LengthOfLastWord().lengthOfLastWord(""));
        System.out.println(new P58_LengthOfLastWord().lengthOfLastWord("xs"));
        System.out.println(new P58_LengthOfLastWord().lengthOfLastWord("   "));
        System.out.println(new P58_LengthOfLastWord().lengthOfLastWord("a b"));
    }

}
