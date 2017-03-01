package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P68_TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();

        int cnt = 0;
        int pos = 0;
        for (int i = 0; i < words.length; i++) {
            int nowCnt = cnt + (cnt > 0 ? 1 : 0) + words[i].length();
            if (nowCnt > maxWidth) {
                int size = i - pos;

                if (size == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(words[pos]);
                    for (int j = 0; j < maxWidth - cnt; j++) {
                        sb.append(" ");
                    }

                    result.add(sb.toString());
                } else {
                    int leftSpace = maxWidth - cnt;

                    int base = leftSpace / (size - 1) + 1;
                    int more = leftSpace % (size - 1);

                    StringBuilder sb = new StringBuilder();
                    for (int j = pos; j < i; j++) {
                        sb.append(words[j]);

                        if (j < i - 1) {
                            for(int k = 0; k < base; k++) {
                                sb.append(" ");
                            }
                            if (more > 0) {
                                sb.append(" ");
                                more --;
                            }
                        }
                    }
                    result.add(sb.toString());
                }

                cnt = words[i].length();
                pos = i;
            } else {
                cnt = nowCnt;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < words.length; i++) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }
        for (int j = 0; j < maxWidth - cnt; j++) {
            sb.append(" ");
        }
        result.add(sb.toString());


        return result;
    }

    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","shall","be."};
        System.out.println(new P68_TextJustification().fullJustify(words, 12));
    }
}
