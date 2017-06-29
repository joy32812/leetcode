package com.leetcode;

/**
 * Created by xiaoyuan on 29/06/2017.
 */
public class P551_StudentAttendanceRecordI {

    public boolean checkRecord(String s) {

        int cntA = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'P') {continue;}
            if (ch == 'A') {cntA++;
                if (cntA >= 2) {return false;}
                continue;
            }

            if (i - 2 >= 0 && s.charAt(i - 2) == 'L' && s.charAt(i - 1) == 'L') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P551_StudentAttendanceRecordI().checkRecord("PPPLPPLPPPLPPPPLPPPPLPPPLLALPP"));
    }

}
