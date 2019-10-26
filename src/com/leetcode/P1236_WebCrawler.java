package com.leetcode;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface HtmlParser {
    List<String> getUrls(String url);
}
public class P1236_WebCrawler {

    Set<String> urlSet;
    HtmlParser hp;

    String hostname;


    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        urlSet = new HashSet<>();
        hp = htmlParser;

        hostname = getHostName(startUrl);
        doCrawl(startUrl);

        List<String> ans = new ArrayList<>();
        ans.addAll(urlSet);

        return ans;
    }

    private String getHostName(String startUrl) {
        URL url = null;
        try {
            url = new URL(startUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url.getHost();
    }

    private void doCrawl(String startUrl) {
        if (urlSet.contains(startUrl)) return;
        urlSet.add(startUrl);

        List<String> urls = hp.getUrls(startUrl);
        for (String url: urls) {
            if(hostname.equals(getHostName(url))) doCrawl(url);
        }
    }

}
