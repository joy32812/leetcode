package com.leetcode

import java.util.*

/**
 * DP + sliding window
 */
fun maxResult(nums: IntArray, k: Int): Int {

    val dp = Array(nums.size) {0}
    dp[0] = nums[0]

    val numMap = mutableMapOf<Int, Int>()
    val treeSet = TreeSet<Int>()
    treeSet += dp[0]
    numMap[dp[0]] = 1

    for (i in 1 until nums.size) {
        val max = treeSet.last()
        dp[i] = max + nums[i]

        treeSet += dp[i]
        numMap[dp[i]] = if (dp[i] in numMap) numMap[dp[i]]!! + 1 else 1

        if (i - k >= 0) {
            numMap[dp[i - k]] = numMap[dp[i - k]]!! - 1
            if (numMap[dp[i - k]] == 0) {
                treeSet -= dp[i - k]
            }
        }
    }

    return dp[nums.size - 1]
}

fun main() {
    println("Hello");
}
