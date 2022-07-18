package com.leetcode


/**
 * Common gcd.
 */
fun minOperations_1(nums: IntArray, numsDivide: IntArray): Int {

    fun gcd(x: Int, y: Int) = x.toBigInteger().gcd(y.toBigInteger()).toInt()

    var g = numsDivide[0]
    for (d in numsDivide) g = gcd(g, d)

    return nums.sorted().indexOfFirst { g % it == 0 }
}

