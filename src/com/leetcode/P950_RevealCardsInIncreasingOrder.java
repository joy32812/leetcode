package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P950_RevealCardsInIncreasingOrder {

    /**
     * use deque to find the right place for elements
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length == 0) return new int[]{};

        Arrays.sort(deck);
        int[] ans = new int[deck.length];


        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            dq.push(i);
        }

        int cnt = 0;
        while (!dq.isEmpty()) {
            ans[dq.getLast()] = deck[cnt];
            cnt++;

            dq.pollLast();
            if (!dq.isEmpty()) dq.addFirst(dq.pollLast());
        }

        return ans;
    }



    public static void main(String[] args) {
        System.out.println(new P950_RevealCardsInIncreasingOrder().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7}));
    }

}
