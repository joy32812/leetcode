package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 05/11/2017.
 */
public class P722_RemoveComments {

    public List<String> removeComments(String[] source) {

        List<String> ans = new ArrayList<>();
        boolean comment = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            String code = source[i];
            while (true) {
                if (comment) {
                    int z = code.indexOf("*/");
                    if (z == - 1) break;

                    code = code.substring(z + 2);
                    comment = false;
                } else {

                    int x = code.indexOf("//");
                    int y = code.indexOf("/*");

                    if (x == -1 && y == -1) {
                        sb.append(code);
                        if (sb.toString().length() > 0) ans.add(sb.toString());

                        comment = false;
                        sb = new StringBuilder();
                        break;
                    } else if (x == -1) {
                        String tt = code.substring(0, y);
                        if (tt.length() > 0) sb.append(tt);

                        code = code.substring(y + 2);

                        comment = true;
                    } else if (y == -1) {
                        String tt = code.substring(0, x);
                        if (tt.length() > 0) sb.append(tt);
                        if (sb.toString().length() > 0) ans.add(sb.toString());


                        comment = false;
                        sb = new StringBuilder();
                        break;
                    } else {
                        if (x < y) {
                            String tt = code.substring(0, x);
                            if (tt.length() > 0) sb.append(tt);
                            if (sb.toString().length() > 0) ans.add(sb.toString());


                            comment = false;
                            sb = new StringBuilder();
                            break;

                        } else {
                            String tt = code.substring(0, y);
                            if (tt.length() > 0) sb.append(tt);

                            code = code.substring(y + 2);

                            comment = true;
                        }

                    }

                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new P722_RemoveComments().removeComments(new String[]{
//                "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
//        }));
//
//        System.out.println(new P722_RemoveComments().removeComments(new String[]{
//                "a/*comment", "line", "more_comment*/b"
//        }));

        System.out.println(new P722_RemoveComments().removeComments(new String[]{
                "a/*/b//*c","blank","d/*/e*//f"
        }));
    }

}
