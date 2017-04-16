package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 16/04/2017.
 */
public class P271_EncodeandDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);

            for (char ch : s.toCharArray()) {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '_') {sb.append(",");}
                sb.append(0 + ch);
            }
            sb.append("_");
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') {
                String str = stringBuilder.toString();
                String[] numStrs = str.split(",");
                StringBuilder sb = new StringBuilder();
                for (String numStr : numStrs) {
                    if (numStr.length() > 0) {
                        sb.append((char)(Integer.parseInt(numStr)));
                    }
                }
                ans.add(sb.toString());
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        List<String> ss = new ArrayList<>();
        ss.add("nSM");
        ss.add("Dsy");

        P271_EncodeandDecodeStrings obj = new P271_EncodeandDecodeStrings();
        System.out.println(obj.decode(obj.encode(ss)));

    }
}
