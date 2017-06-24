package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 24/06/2017.
 */
public class P522_LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {

        List<String> strList = new ArrayList<>();
        for (String s : strs) {strList.add(s);}

        return work(strList);
    }

    private int work(List<String> strList) {
        if (strList.size() == 0) {return -1;}
        if (strList.size() == 1) {return strList.get(0).length();}

        strList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return -(o1.length() - o2.length());
            }
        });

        String first = strList.get(0);
        if (!first.equals(strList.get(1))) {return first.length();}

        List<String> leftList = new ArrayList<>();
        for (int i = 1; i < strList.size(); i++) {
            if (!isSubSeq(first, strList.get(i))) {
                leftList.add(strList.get(i));
            }
        }


        return work(leftList);
    }


    private boolean isSubSeq(String s, String t) {

        int x = 0;
        int y = 0;
        while (true) {
            if (y == t.length()) {return true;}
            if (x == s.length()) {return false;}

            if (s.charAt(x) == t.charAt(y)) {
                x++;
                y++;
            } else {
                x++;
            }
        }
    }

}
