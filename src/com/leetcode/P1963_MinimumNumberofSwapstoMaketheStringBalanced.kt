package com.leetcode


/**
 * Greedy
 */
fun minSwaps2(s: String): Int {

    var diff = 0
    var ans = 0

    for (ch in s) {
        if (ch == ']') diff --
        else diff ++

        if (diff < 0) {
            ans ++
            diff = 1
        }
    }

    return ans
}
