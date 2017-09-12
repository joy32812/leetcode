package com.leetcode;

/**
 * Created by xiaoyuan on 12/09/2017.
 */
public class P466_CountTheRepetitions {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {return 0;}

        int i = 0;
        int cntI = 0;

        int j = 0;
        int cntJ = 0;
        while (true) {

            if (s1.charAt(i) == s2.charAt(j)) {
                i ++;
                j ++;
            } else {
                i ++;
            }

            if (j == s2.length()) {
                j = 0;
                cntJ ++;
            }
            if (i == s1.length()) {
                i = 0;
                cntI ++;

                if (cntI >= n1) {return cntJ / n2;}
            }


            if (i == 0 && j == 0) {break;}
        }

        return n1 * cntJ / cntI / n2;
    }

    public static void main(String[] args) {
        System.out.println(new P466_CountTheRepetitions().getMaxRepetitions("acb", 1, "acb", 1));

//        System.out.println(new P466_CountTheRepetitions().getMaxRepetitions("acb", 4, "ab", 2));
//        System.out.println(new P466_CountTheRepetitions().getMaxRepetitions("abaacdbac", 100, "adcbd", 4));
    }

}
