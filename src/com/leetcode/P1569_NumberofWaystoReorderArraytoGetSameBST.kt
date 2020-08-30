package com.leetcode

/**
 * tree dp
 */
val MOD = 1000000000L + 7;
fun numOfWays(nums: IntArray): Int {
    val size = nums.size
    val dp = Array(size) { Array(size) {1L} }
    for (i in 1 until size) {
        for (j in 1 until size) dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD
    }

    fun work(data: List<Int>): Long {
        if (data.size <= 2) return 1

        val small = mutableListOf<Int>()
        val big = mutableListOf<Int>()
        for (i in 1 until data.size) {
            if (data[i] < data[0]) small += data[i]
            if (data[i] > data[0]) big += data[i]
        }

        val subAns = work(big) * work(small) % MOD
        return (subAns * dp[small.size][big.size]) % MOD
    }

    return ((work(nums.toList()) - 1 + MOD) % MOD).toInt()
}


fun main() {
//    println(numOfWays(intArrayOf(2, 1, 3)))
//    println(numOfWays(intArrayOf(3, 4, 5, 1, 2)))
    println(numOfWays(intArrayOf(30,11,46,3,29,22,37,32,13,49,48,16,40,8,24,44,9,39,25,21,41,26,43,19,47,7,10,31,45,4,35,14,20,23,15,17,38,2,6,18,5,33,27,36,42,28,12,34,1)))
}
