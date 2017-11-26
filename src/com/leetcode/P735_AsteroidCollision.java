package com.leetcode;

import java.util.*;

/**
 * Created by xiaoyuan on 26/11/2017.
 */
public class P735_AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return new int[]{};

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            }

            int tp = stack.peek();
            if (tp * asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else if (tp > 0) {
                stack.pop();
                if (tp + asteroids[i] > 0) {
                    if (tp > 0) {
//                        stack.push(tp);
                        asteroids[i] = tp;
                    } else {
//                        stack.push(asteroids[i]);
                        asteroids[i] = asteroids[i];
                    }
                    i--;

                } else if (tp + asteroids[i] == 0) {

                } else {
                    if (tp < 0) {
//                        stack.push(tp);
                        asteroids[i] = tp;
                    } else {
                        asteroids[i] = asteroids[i];
//                        stack.push(asteroids[i]);
                    }
                    i--;
                }
            } else {
                stack.push(asteroids[i]);
            }
        }

        int size = stack.size();
        int[] ans = new int[size];
//        List<Integer> z = new ArrayList<>();

        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
//            z.add(ans[i]);
        }
//        System.out.println(z);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P735_AsteroidCollision().asteroidCollision(new int[]{-2, -2, -2, 1}));
        System.out.println(new P735_AsteroidCollision().asteroidCollision(new int[]{10, 2, -5}));
    }

}
