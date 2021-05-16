package com.leetcode

/**
 * easy
 * string compare
 */
fun minSwaps(s: String): Int {

    val ones = s.count { it == '1' }
    val zeros = s.count { it == '0' }
    if (Math.abs(ones - zeros) > 1) return -1

    fun count(first: Int) = s.mapIndexed { index, c -> if (c - '0' == (index + first) % 2) 0 else 1 }.sum() / 2

    if (ones == zeros) return Math.min(count(0), count(1))
    return if (ones > zeros) count(1) else count(0)
}

fun main() {
    println(minSwaps("111000"))
}
