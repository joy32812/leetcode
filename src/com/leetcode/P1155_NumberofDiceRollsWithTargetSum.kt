package com.leetcode

fun numRollsToTarget(d: Int, f: Int, target: Int): Int {

    val dp = Array(d + 1) { Array(target + 1) { -1} }

    val mod = 1_000_000_000 + 7

    fun getNum(d: Int, f: Int, target: Int): Int {
        if (d == 0 && target == 0) return 1
        if (d == 0) return 0
        if (dp[d][target] != -1) return dp[d][target]

        var ans = 0
        for (i in 1..f) {
            if (i > target) break
            ans = (ans + getNum(d - 1, f, target - i)) % mod
        }

        dp[d][target] = ans
        return dp[d][target]
    }

    return getNum(d, f, target)

}

fun main() {
    println(numRollsToTarget(1, 6, 3))
    println(numRollsToTarget(2, 6, 7))
    println(numRollsToTarget(2, 5, 10))
    println(numRollsToTarget(1, 2, 3))
    println(numRollsToTarget(30, 30, 500))
}