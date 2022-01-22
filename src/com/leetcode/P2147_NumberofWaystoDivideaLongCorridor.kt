package com.leetcode

import java.math.BigInteger

/**
 * Easy combinations
 */
fun numberOfWays(corridor: String): Int {
    val count = corridor.count { it == 'S' }
    if (count == 0) return 0
    if (count % 2 == 1) return 0

    val MOD = 1_000_000_000 + 7
    val seats = corridor.withIndex().filter { it.value == 'S' }

    return (2 until seats.size step 2)
        .fold(1L) { acc, i -> acc * (seats[i].index - seats[i - 1].index) % MOD }
        .toInt()
}
