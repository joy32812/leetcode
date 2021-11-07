package com.leetcode

/**
 * binary search
 */
fun minimizedMaximum(n: Int, quantities: IntArray): Int {
    var l = 0
    var r = quantities.max()!! + 1

    fun okay(m: Int): Boolean {
        if (m == 0) return false
        var zn = n
        for (d in quantities) {
            zn -= d / m + (if (d % m == 0) 0 else 1)
            if (zn < 0) return false
        }
        return true
    }

    while (l < r) {
        val m = (l + r) / 2
        if (okay(m)) r = m
        else l = m + 1
    }

    return l
}

fun main() {
    println(minimizedMaximum(6, intArrayOf(11, 6)))
}
