package com.leetcode

/**
 * easy
 */
fun isThree(n: Int): Boolean {
    return (1..n).count { n % it == 0 } == 3
}
