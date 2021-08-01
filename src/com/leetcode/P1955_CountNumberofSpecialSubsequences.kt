package com.leetcode

/**
 * DP
 */
fun countSpecialSubsequences(nums: IntArray): Int {

    val MOD = 1_000_000_000 + 7
    val count = Array(4) { 0L }

    for (d in nums) {
        if (d == 0)  {
            count[0] = (2 * count[0] + 1) % MOD
        } else if (d == 1) {
            count[1] = (2 * count[1] + count[0]) % MOD
        } else {
            count[2] = (2 * count[2] + count[1]) % MOD
        }
    }

    return count[2].toInt()
}


