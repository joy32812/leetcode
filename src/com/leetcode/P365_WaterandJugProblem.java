package com.leetcode;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xiaoyuan on 16/05/2017.
 */
public class P365_WaterandJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || z == x || z == y || z == x + y) {return true;}
        if (z < 0 || z > x + y) {return false;}

        int gcd = new BigInteger("" + x).gcd(new BigInteger("" + y)).intValue();

        return z % gcd == 0;
    }

    public static void main(String[] args) {
    }

}
