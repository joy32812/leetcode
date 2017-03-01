package com.leetcode;

import java.util.Stack;

/**
 * Created by xiaoyuan on 01/03/2017.
 */
public class P71_SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> pathStack = new Stack<String>();

        int pos = 0;
        while (pos < path.length()) {
            StringBuilder sb = new StringBuilder();
            pos ++;
            while (pos < path.length() && path.charAt(pos) != '/') {
                sb.append(path.charAt(pos));
                pos ++;
            }

            String name = sb.toString();
            if (name.equals(".")) {

            } else if (name.equals("..")) {
                if (!pathStack.empty()) {
                    pathStack.pop();
                }
            } else if (name.length() > 0){
                pathStack.push(name);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!pathStack.empty()) {
            ans.append(new StringBuilder(pathStack.pop()).reverse().toString());
            ans.append("/");
        }
        if (ans.length() == 0) {
            ans.append("/");
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new P71_SimplifyPath().simplifyPath("/../"));
        System.out.println(new P71_SimplifyPath().simplifyPath("/home/"));
        System.out.println(new P71_SimplifyPath().simplifyPath("/home/../"));
        System.out.println(new P71_SimplifyPath().simplifyPath("/a/./b/../../c/"));
    }

}
