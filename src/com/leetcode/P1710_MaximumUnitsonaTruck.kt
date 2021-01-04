package com.leetcode

fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    boxTypes.sortByDescending { it[1] }
    var ans = 0
    var size = truckSize
    for (bt in boxTypes) {
        val usedSize = if (size >= bt[0]) bt[0] else size
        size -= usedSize
        ans += usedSize * bt[1]
    }

    return ans
}
