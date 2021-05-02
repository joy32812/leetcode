package com.leetcode

/**
 * easy
 * sort and one pass
 */
fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    arr.sort()

    var now = 0
    for (d in arr) if (d > now) now++
    return now
}
