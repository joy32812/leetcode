package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyuan on 03/07/2017.
 */
public class P635_DesignLogStorageSystem {

    private List<String> logList;
    private List<Integer> idList;

    public P635_DesignLogStorageSystem() {
        logList = new ArrayList<>();
        idList = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        logList.add(timestamp);
        idList.add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        Map<String, Integer> posMap = new HashMap<>();
        posMap.put("Year", 4);
        posMap.put("Month", 7);
        posMap.put("Day", 10);
        posMap.put("Hour", 13);
        posMap.put("Minute", 16);
        posMap.put("Second", 19);

        int subLen = posMap.get(gra);

        String subS = s.substring(0, subLen);
        String subE = e.substring(0, subLen);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < logList.size(); i++) {
            String log = logList.get(i);
            String subLog = log.substring(0, subLen);
            if (subLog.compareTo(subS) >= 0 && subLog.compareTo(subE) <= 0) {
                ans.add(idList.get(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        P635_DesignLogStorageSystem obj = new P635_DesignLogStorageSystem();
        obj.put(1, "2017:01:01:23:59:59");
        System.out.println(obj.retrieve("2017:01:01:23:00:00", "2017:01:01:23:00:00", "Year"));

    }

}
