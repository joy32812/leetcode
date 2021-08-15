package com.leetcode

/**
 * quick powMod
 *
 * (A * B) mod C = ((A mod C) * (B mod C)) mod C
 */
fun minNonZeroProduct(p: Int): Int {

    val MOD = 1_000_000_000 + 7

    val last = (1L shl p) - 1
    val x = last - 1
    val y = (1L shl p - 1) - 1

    fun power(a: Long, b: Long): Long {
        if (b == 0L) return 1L

        val half = power(a, b / 2)
        var tmp =  (half % MOD) * (half % MOD) % MOD
        if (b % 2 == 1L) tmp = tmp * (a % MOD) % MOD
        return tmp
    }

    return (power(x, y) * (last % MOD) % MOD).toInt()
}

fun main() {

    println(minNonZeroProduct(34))
    println(minNonZeroProduct(35))

}
