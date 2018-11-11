package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P937_ReorderLogFiles {


    /**
     * easy sort
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {

        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for (String s : logs) {
            String[] ss = s.split(" ");

            if (Character.isDigit(ss[1].charAt(0))) {
                digitList.add(s);
            } else {
                letterList.add(s);
            }
        }

        letterList.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String[] as = a.split(" ");
                String[] bs = b.split(" ");

                String aLeft = a.substring(as[0].length());
                String bLeft = b.substring(bs[0].length());

                if (aLeft.equals(bLeft)) {
                    return as[0].compareTo(bs[0]);
                }

                return aLeft.compareTo(bLeft);
            }
        });

        letterList.addAll(digitList);
        return letterList.stream().toArray(size -> new String[size]);
    }



    public static void main(String[] args) {

    }

}
