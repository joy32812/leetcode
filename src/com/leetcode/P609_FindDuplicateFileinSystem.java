package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 01/07/2017.
 */
public class P609_FindDuplicateFileinSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> fileMap = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            String dir = files[0];

            for (int i = 1; i < files.length; i++) {
                String[] fileAndContents = files[i].split("\\(");
                String theFile = dir + "/" + fileAndContents[0];
                String content = fileAndContents[1];

                fileMap.computeIfAbsent(content, k -> new ArrayList<String>()).add(theFile);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : fileMap.values()) {
            if (list.size() >= 2) {
                ans.add(list);
            }
        }

        return ans;
    }

}
