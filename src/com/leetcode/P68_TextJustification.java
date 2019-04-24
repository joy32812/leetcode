package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P68_TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<List<String>> lines = new ArrayList<>();
        int num = -1;
        List<String> oneLine = new ArrayList<>();
        for (String w : words) {
            if (num + 1 + w.length() > maxWidth) {
                if (oneLine.size() > 0) lines.add(oneLine);
                oneLine = new ArrayList<>();
                oneLine.add(w);
                num = w.length();
            } else {
                oneLine.add(w);
                num += 1 + w.length();
            }
        }
        if (oneLine.size() > 0) lines.add(oneLine);

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < lines.size() - 1; i++) {
            List<String> line = lines.get(i);
            ans.add(createLine(line, maxWidth));
        }

        ans.add(lastLine(lines.get(lines.size() - 1), maxWidth));

        return ans;
    }

    private String lastLine(List<String> line, int width) {
        int num = line.get(0).length();
        StringBuilder sb = new StringBuilder(line.get(0));

        for (int i = 1; i < line.size(); i++) {
            sb.append(" ");
            sb.append(line.get(i));
            num += 1 + line.get(i).length();
        }
        for (int i = 0; i < (width - num); i++) sb.append(" ");

        return sb.toString();
    }

    private String createLine(List<String> line, int width) {
        int total = 0;
        for (String w : line) total += w.length();
        int spaceNum = width - total;

        StringBuilder sb = new StringBuilder(line.get(0));
        if (line.size() == 1) {
            for (int i = 0; i < spaceNum; i++) sb.append(" ");
            return sb.toString();
        }

        int avg = spaceNum / (line.size() - 1);
        int remain = spaceNum % (line.size() - 1);

        for (int i = 1; i < line.size(); i++) {
            for (int j = 0; j < avg; j++) sb.append(" ");
            if (remain > 0) {
                sb.append(" ");
                remain --;
            }

            sb.append(line.get(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","shall","be."};
        System.out.println(new P68_TextJustification().fullJustify(words, 12));
    }
}
