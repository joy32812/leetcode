package com.leetcode

fun countPairs(deliciousness: IntArray): Int {
    val MOD = 1_000_000_000 + 7L

    val gb = deliciousness.groupBy { it }.mapValues { it.value.size }
    val sorted = deliciousness.distinct().sorted()

    var ans = 0L
    for (d in sorted) {
        for (i in 21 downTo 0) {
            val f = (1 shl i) - d
            if (f == d) {
                ans += 1L * gb[d]!! * (gb[d]!! - 1) / 2
                ans %= MOD
            } else if (f > d) {
                if (f in gb) {
                    ans += 1L * gb[f]!! * gb[d]!!
                    ans %= MOD
                }
            } else break
        }
    }

    return ans.toInt()
}
