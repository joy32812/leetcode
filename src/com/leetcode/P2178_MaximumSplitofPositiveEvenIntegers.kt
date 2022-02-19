package com.leetcode


/**
 * Greedy
 */
fun maximumEvenSplit(finalSum: Long): List<Long> {
    if (finalSum % 2 != 0L) return listOf()

    val ans = mutableListOf<Long>()
    var total = finalSum
    var now = 2L
    while (now <= total) {
        ans += now
        total -= now
        now += 2
    }

    if (total != 0L) ans[ans.size - 1] += total

    return ans
}

fun main() {
    println(maximumEvenSplit(12L))
}
