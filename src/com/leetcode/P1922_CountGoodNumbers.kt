package com.leetcode

/**
 * pow MOD function.
 */
fun countGoodNumbers(n: Long): Int {

    val MOD = 1_000_000_000 + 7
    val x = (n + 1) / 2
    val y = n / 2


    fun powMod(a: Int, b: Long): Long {
        if (b == 0L) return 1

        val half = powMod(a, b / 2)
        if (b % 2 == 0L) return half * half % MOD
        return half * half * a % MOD
    }

    return (powMod(5, x) * powMod(4, y) % MOD).toInt()

}
