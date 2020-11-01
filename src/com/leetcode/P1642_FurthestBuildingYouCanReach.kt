package com.leetcode

/**
 * binary search + greedy
 */
fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {

    fun okay(n: Int): Boolean {
        val diffs = (1..n).filter { heights[it] > heights[it - 1] }.map { heights[it] - heights[it - 1] }
        val sortedDiff = diffs.sortedDescending()
        return sortedDiff.filterIndexed { index, _ -> index >= ladders }.sum() <= bricks
    }

    var l = 0
    var r = heights.size
    while (l < r) {
        val m = (l + r) / 2
        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1;
}


fun main() {
//    println(furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1))
    println(furthestBuilding(intArrayOf(4,12,2,7,3,18,20,3,19), 10, 2))
}
