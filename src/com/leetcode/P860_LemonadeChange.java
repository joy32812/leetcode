package com.leetcode;

public class P860_LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];

        for (int b : bills) {

            if (b == 5) money[0] ++;
            else if (b == 10) {
                if (money[0] == 0) return false;
                money[0] --;
                money[1] ++;
            } else {
                int now = 15;
                if (money[1] > 0) {
                    money[1] --;
                    now = 5;
                }

                if (now == 5 && money[0] >= 1) {
                    money[0] --;
                } else if (now == 15 && money[0] >= 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
            }

        }

        return true;
    }

}
