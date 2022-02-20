package com.leetcode

/**
 * GCD
 */
fun countPairs_(nums: IntArray, k: Int): Long {

    fun gcd(x: Int, y: Int) = x.toBigInteger().gcd(y.toBigInteger()).toLong()
    val gcds = mutableMapOf<Long, Int>()

    var ans = 0L
    for (d in nums) {
        val g1 = gcd(d, k)
        for ((g2, num) in gcds) {
            if (g1 * g2 % k == 0L) ans += num
        }

        gcds[g1] = (gcds[g1] ?: 0) + 1
    }

    return ans
}
