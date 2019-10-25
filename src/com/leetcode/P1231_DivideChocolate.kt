package com.leetcode



fun maximizeSweetness(sweetness: IntArray, K: Int): Int {


    var l = 0
    var r = sweetness.sum() + 1

    fun okay(x: Int): Boolean {
        var cnt = 0
        var total = 0
        for (d in sweetness) {
            total += d
            if (total >= x) {
                cnt ++
                total = 0
            }
        }

        return cnt >= K + 1
    }

    while (l < r) {
        val m = (l + r) / 2

        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1
}

fun main() {
    println(maximizeSweetness(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5))
}
