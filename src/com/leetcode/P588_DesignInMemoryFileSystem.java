package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 22/09/2017.
 */
public class P588_DesignInMemoryFileSystem {

    private class Path {
        boolean isDir;
        String name;
        String content;
        Map<String, Path> fileMap;

        public Path() {
            this.isDir = true;
            this.content = "";
            this.name = "";
            this.fileMap = new HashMap<>();
        }
    }

    private Path root;
    public P588_DesignInMemoryFileSystem() {
        root = new Path();
    }

    public List<String> ls(String path) {
        String[] nodes = path.split("/");

        Path now = root;
        for (int i = 1; i < nodes.length; i++) {
            now = now.fileMap.get(nodes[i]);
        }

        List<String> ans = new ArrayList<>();
        if (!now.isDir) {
            ans.add(now.name);
            return ans;
        }

        Set<String> keySet = now.fileMap.keySet();
        for (String z : keySet) {ans.add(z);}

        ans.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        return ans;
    }

    public void mkdir(String path) {
        String[] nodes = path.split("/");

        Path now = root;
        for (int i = 1; i < nodes.length; i++) {
            if (!now.fileMap.containsKey(nodes[i])) {
                now.fileMap.put(nodes[i], new Path());
            }
            now = now.fileMap.get(nodes[i]);
        }

    }

    public void addContentToFile(String filePath, String content) {
        String[] nodes = filePath.split("/");

        Path now = root;
        for (int i = 1; i < nodes.length - 1; i++) {
            now = now.fileMap.get(nodes[i]);
        }

        String fileName = nodes[nodes.length - 1];
        if (!now.fileMap.containsKey(fileName)) {
            Path file = new Path();
            file.isDir = false;
            file.name = fileName;
            file.content = content;
            now.fileMap.put(fileName, file);
        } else {
            now.fileMap.get(fileName).content += content;
        }
    }

    public String readContentFromFile(String filePath) {
        String[] nodes = filePath.split("/");

        Path now = root;
        for (int i = 1; i < nodes.length - 1; i++) {
            now = now.fileMap.get(nodes[i]);
        }

        String fileName = nodes[nodes.length - 1];

        return now.fileMap.get(fileName).content;
    }

    public static void main(String[] args) {

        P588_DesignInMemoryFileSystem obj = new P588_DesignInMemoryFileSystem();
        obj.mkdir("/goowmfn");
        obj.mkdir("/z");
        obj.addContentToFile("/goowmfn/c", "shetopcy");


        System.out.println(obj.ls("/z"));
        System.out.println(obj.ls("/goowmfn/c"));
        System.out.println(obj.ls("/goowmfn"));

    }

}
