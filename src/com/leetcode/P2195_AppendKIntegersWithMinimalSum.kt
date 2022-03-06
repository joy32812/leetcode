package com.leetcode

/**
 * set
 */
fun minimalKSum(nums: IntArray, k: Int): Long {

    val set = nums.toSet()

    var i = 0
    var now = 1
    var ans = 0L
    while (i < k) {
        if (now in set) {
            now ++
            continue
        }

        ans += now
        now ++
        i ++
    }

    return ans
}
