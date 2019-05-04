package com.leetcode;

import java.util.Random;

public class P478_GenerateRandomPointinaCircle {


    class Solution {

        double rad;
        double x;
        double y;
        public Solution(double radius, double x_center, double y_center) {
            rad = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {

            double len = Math.sqrt(Math.random()) * rad;
            double degree = Math.random() * 2 * Math.PI;

            double tx = len * Math.cos(degree);
            double ty = len * Math.sin(degree);
            return new double[]{tx + x, ty + y};
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextDouble());
        System.out.println(r.nextDouble());
    }



}
