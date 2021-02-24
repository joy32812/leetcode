package com.leetcode

fun findBuildings(heights: IntArray): IntArray {

    val ans = mutableListOf<Int>()
    var currentMax = 0
    for (i in heights.indices.reversed()) {
        if (heights[i] > currentMax) ans += i
        currentMax = Math.max(currentMax, heights[i])
    }

    return ans.sorted().toIntArray()
}
