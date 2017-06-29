package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P557_ReverseWordsinaStringIII {

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (String ss : s.split(" ")) {
            list.add(new StringBuilder(ss).reverse().toString());
        }


        return String.join(" ", list);
    }

}
