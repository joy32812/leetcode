package com.leetcode;

public class P942_DIStringMatch {


    /**
     * a much more elegant way
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {

        int N = S.length();
        int low = 0, high = N;

        int[] ans = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') ans[i] = low++;
            else ans[i] = high--;
        }

        ans[N] = low;

        return ans;
    }


    /**
     * we cat get S(i) by S(i - 1)
     * @param S
     * @return
     */
    public int[] diStringMatch2(String S) {

        int[] ans = new int[S.length() + 1];
        if (S.charAt(0) == 'I') {
            ans[0] = 0;
            ans[1] = 1;
        } else {
            ans[0] = 1;
            ans[1] = 0;
        }

        for (int i = 1; i < S.length(); i++) {
            int now = i + 1;

            if (S.charAt(i) == 'I') {
                ans[i + 1] = now;
            } else {

                int j = i;
                for (; j >= 0; j--) {
                    if (S.charAt(j) == 'D') {
                        ans[j + 1] = ans[j];
                    } else {
                        ans[j + 1] = now;
                        break;
                    }
                }

                if (j == -1) ans[0] = now;

            }
        }

        return ans;
    }



    public static void main(String[] args) {

        int[] ans = new P942_DIStringMatch().diStringMatch("DDI");

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

}
