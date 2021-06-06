package com.leetcode

/**
 * Binary search
 */
fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
    packages.sort()

    fun bs(size: Int): Int {
        var l = 0
        var r = packages.size

        while (l < r) {
            val m = (l + r) / 2
            if (packages[m] > size) r = m
            else l = m + 1
        }

        return l - 1
    }

    var ans = Long.MAX_VALUE
    var packageSum = packages.map { it.toLong() }.sum()

    for (box in boxes) {
        box.sort()
        var last = -1
        if (box.last() < packages.last()) continue

        var totalBoxSize = 0L
        for (i in box.indices) {
            val index = bs(box[i])

            val num = index - last
            totalBoxSize += 1L * box[i] * num

            last = index
        }

        ans = Math.min(ans, totalBoxSize - packageSum)
    }

    if (ans == Long.MAX_VALUE) return -1

    val MOD = 1_000_000_000 + 7
    return (ans % MOD).toInt()
}

fun main() {
    println(minWastedSpace(
        intArrayOf(2, 3, 5),
        arrayOf(
            intArrayOf(4, 8),
            intArrayOf(2, 8)
        )
    ))
}
