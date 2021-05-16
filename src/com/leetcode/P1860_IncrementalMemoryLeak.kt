package com.leetcode

/**
 * brute force
 */
fun memLeak(memory1: Int, memory2: Int): IntArray {

    var m1 = memory1
    var m2 = memory2

    var i = 1
    while (i <= m1 || i <= m2) {
        if (m1 >= m2 && m1 >= i) {
            m1 -= i
        } else {
            m2 -= i
        }
        i ++
    }

    return intArrayOf(i, m1, m2)
}
