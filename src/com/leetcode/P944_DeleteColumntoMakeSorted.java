package com.leetcode;

public class P944_DeleteColumntoMakeSorted {


    /**
     * easy
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        if (A == null || A[0].length() == 0) return 0;

        int len = A[0].length();

        int num = 0;
        for (int j = 0; j < len; j++) {

            boolean sort = true;
            for (int i = 1; i < A.length; i++) {
                if (A[i].charAt(j) >= A[i - 1].charAt(j)) continue;

                sort = false;
                break;
            }

            if (sort) num++;
        }

        return len - num;
    }



    public static void main(String[] args) {

    }

}
