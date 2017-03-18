package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiaoyuan on 18/03/2017.
 *
 * equal situation is annoying!
 */
public class P135_Candy {

    public int candy(int[] ratings) {
        if (ratings.length == 0) {return 0;}

        int n = ratings.length;

        Queue<Integer> Q = new LinkedList<Integer>();
        boolean[] visit = new boolean[n];
        int[] candyNum = new int[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (lessThanOrEqual(ratings, i, i - 1) && lessThanOrEqual(ratings, i, i + 1)) {
                candyNum[i] = 1;
                ans ++;

                int x = i - 1;
                if (x >= 0 && x < n && candyNum[x] == 0 && visit[x] == false) {
                    Q.add(x);
                    visit[x] = true;
                }

                x = i + 1;
                if (x >= 0 && x < n && candyNum[x] == 0 && visit[x] == false) {
                    Q.add(x);
                    visit[x] = true;
                }
            }
        }

        while (!Q.isEmpty()) {
            int p = Q.poll();
            visit[p] = false;


            int l = p - 1;
            int r = p + 1;
            if (l >= 0 && l < n && ratings[l] == ratings[p]) {
                if (greatThan(ratings, p, r)) {
                    int right = getCandyNum(candyNum, r);
                    candyNum[p] = right + 1;
                    ans += candyNum[p];
                }
            } else if (r >= 0 && r < n && ratings[r] == ratings[p]) {
                if (greatThan(ratings, p, l)) {
                    int left = getCandyNum(candyNum, l);
                    candyNum[p] = left + 1;
                    ans += candyNum[p];
                }
            } else if (greatThan(ratings, p, l) && greatThan(ratings, p, r)) {
                int left = getCandyNum(candyNum, l);
                int right = getCandyNum(candyNum, r);
                if (left != 0 && right != 0) {
                    candyNum[p] = 1 + Math.max(left, right);
                    ans += candyNum[p];
                }
            } else if (greatThan(ratings, p, l)) {
                int left = getCandyNum(candyNum, l);
                candyNum[p] = left + 1;
                ans += candyNum[p];
                if (r >= 0 && r < n && candyNum[r] == 0 && visit[r] == false) {
                    Q.add(r);
                    visit[r] = true;
                }

            } else if (greatThan(ratings, p, r)) {
                int right = getCandyNum(candyNum, r);
                candyNum[p] = right + 1;
                ans += candyNum[p];

                if (l >= 0 && l < n && candyNum[l] == 0 && visit[l] == false) {
                    Q.add(l);
                    visit[l] = true;
                }
            }

        }


        return ans;
    }

    private int getCandyNum(int[] candyNum, int x) {
        if (x < 0 || x >= candyNum.length) {return -1;}
        return candyNum[x];
    }


    private boolean lessThanOrEqual(int[] arr, int x, int y) {
        if (y < 0 || y >= arr.length) {return true;}
        return arr[x] <= arr[y];
    }
    private boolean greatThan(int[] arr, int x, int y) {
        if (y < 0 || y >= arr.length) {return true;}
        return arr[x] > arr[y];
    }


    public static void main(String[] args) {
        System.out.println(new P135_Candy().candy(new int[]{1, 4, 1, 4, 4, 3, 10, 10, 9, 8, 8, 2}));
        System.out.println(new P135_Candy().candy(new int[]{1, 2, 4, 4, 3}));
        System.out.println(new P135_Candy().candy(new int[]{1, 2, 2, 2, 2, 2 ,2, 2, 2, 1}));
    }

}
