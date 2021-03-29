package com.leetcode

/**
 * brute force
 */
fun reinitializePermutation(n: Int): Int {
    var now = (0 until n).map { it }

    var cnt = 0
    while (true) {
        cnt ++
        now = now.withIndex().map { Pair(if (it.index % 2 == 0) it.index / 2 else n / 2 + (it.index - 1) / 2, it.value) }.sortedBy { it.first }.map { it.second }
        if (now.withIndex().all { it.index == it.value }) break
    }

    return cnt
}
