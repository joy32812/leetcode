package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoyuan on 13/05/2017.
 */
public class P359_LoggerRateLimiter {

}

class Logger {

    private Map<String, Integer> logMap;
    /** Initialize your data structure here. */
    public Logger() {
        logMap = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!logMap.containsKey(message)) {
            logMap.put(message, timestamp);
            return true;
        }

        if (timestamp - logMap.get(message) >= 10) {
            logMap.put(message, timestamp);
            return true;
        }

        return false;
    }
}