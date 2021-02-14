package com.leetcode

/**
 * binary search
 */
fun minimumSize(nums: IntArray, maxOperations: Int): Int {
    var l = 1
    var r = nums.max()!! + 1

    fun getOpNums(maxBalls: Int): Int {
        return nums.map { (it - 1) / maxBalls }.sum()
    }

    while (l < r) {
        val m = (l + r) / 2
        if (getOpNums(m) <= maxOperations) r = m
        else l = m + 1
    }

    return l
}

fun main() {
    println(minimumSize(intArrayOf(9), 2))
    println("Hello")
}
