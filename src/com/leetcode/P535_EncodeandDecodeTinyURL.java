package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by xiaoyuan on 26/09/2017.
 */
public class P535_EncodeandDecodeTinyURL {
    private class Codec {

        private Map<String, String> enMap = new HashMap<>();
        private Map<String, String> deMap = new HashMap<>();
        private Random rand = new Random();

        private String getKey() {

            String key = "";
            while (true) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    int p = rand.nextInt(62);
                    if (p < 10) sb.append((char)('0' + p));
                    else if (p < 36) sb.append((char)('a' + (p - 10)));
                    else sb.append((char)('A' + (p - 36)));
                }

                if (!deMap.containsKey(sb.toString())) {
                    key = sb.toString();
                    break;
                }
            }

            return key;
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String key = getKey();
            enMap.put(longUrl, key);
            deMap.put(key, longUrl);

            return key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return deMap.getOrDefault(shortUrl, "");
        }
    }

    public static void main(String[] args) {

        P535_EncodeandDecodeTinyURL obj = new P535_EncodeandDecodeTinyURL();
        obj.test();

    }

    private void test() {

        Codec codec = new Codec();
        String x = codec.encode("https://leetcode.com/problems/design-tinyurl");

        System.out.println(x);

        System.out.println(codec.decode(x));
    }

}

