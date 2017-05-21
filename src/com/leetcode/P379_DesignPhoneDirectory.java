package com.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xiaoyuan on 21/05/2017.
 */
public class P379_DesignPhoneDirectory {

}

class PhoneDirectory {


    private Set<Integer> phoneSet;
    private TreeSet<Integer> releaseSet;
    private int cnt;
    private int maxNum;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        cnt = 0;
        maxNum = maxNumbers;
        phoneSet = new HashSet<>();
        releaseSet = new TreeSet<>();
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (releaseSet.isEmpty()) {
            if (cnt == maxNum) {return -1;}

            phoneSet.add(cnt);
            return cnt++;
        }

        int now = releaseSet.first();
        releaseSet.remove(now);
        phoneSet.add(now);
        return now;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !phoneSet.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (!phoneSet.contains(number)) {return;}

        phoneSet.remove(number);
        releaseSet.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */