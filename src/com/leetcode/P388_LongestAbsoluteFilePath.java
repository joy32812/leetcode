package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoyuan on 24/05/2017.
 */
public class P388_LongestAbsoluteFilePath {

    private class FileNode {
        String name;
        int totalLen;
        int level;

        public FileNode(String name, int totalLen, int level) {
            this.name = name;
            this.totalLen = totalLen;
            this.level = level;
        }
    }

    public int lengthLongestPath(String input) {
        int ans = 0;
        input = input.replaceAll("(\n)", "@");
        input = input.replaceAll("(\t)", "=");
        String[] nodes = input.split("@");

        List<FileNode> nodeList = new ArrayList<>();
        int[] levelFather = new int[nodes.length];

        for (String node : nodes) {

            int level = 0;
            for (char ch : node.toCharArray()) {
                if (ch == '=') {
                    level++;
                }else {
                    break;
                }
            }

            int last = 0;
            if (level > 0) {
                last += nodeList.get(levelFather[level - 1]).totalLen;
            }

            String name = node.substring(level);

            FileNode theNode = new FileNode(name, last + name.length(), level);
            nodeList.add(theNode);
            levelFather[level] = nodeList.size() - 1;

            if (name.indexOf('.') > -1) {
                ans = Math.max(ans, theNode.totalLen);
            } else {
                theNode.totalLen++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P388_LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

}
