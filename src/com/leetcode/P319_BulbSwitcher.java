package com.leetcode;

/**
 * Created by xiaoyuan on 30/04/2017.
 */
public class P319_BulbSwitcher {

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(new P319_BulbSwitcher().bulbSwitch(100));
    }

}
