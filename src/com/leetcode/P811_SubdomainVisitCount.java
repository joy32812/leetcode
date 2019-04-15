package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P811_SubdomainVisitCount {

    /**
     * easy
     *
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> cntMap = new HashMap<>();

        for (String cpd : cpdomains) {
            String[] splits = cpd.split(" ");

            int num = Integer.parseInt(splits[0]);
            List<String> parentDomains = getParent(splits[1]);

            for (String dom : parentDomains) {
                cntMap.put(dom, cntMap.getOrDefault(dom, 0) + num);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String domain : cntMap.keySet()) {
            ans.add(cntMap.get(domain) + " " + domain);
        }
        return ans;
    }

    private List<String> getParent(String s) {

        List<String> ans = new ArrayList<>();

        while (s.length() > 0) {
            ans.add(s);
            int index = s.indexOf('.');
            if (index == -1) break;
            s = s.substring(index + 1);
        }

        return ans;
    }

}
