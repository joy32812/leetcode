package com.leetcode

/**
 * easy, simulation
 */
fun getLucky(s: String, k: Int): Int {
    var numStr = s.map { it - 'a' + 1 }.joinToString("")

    var ans = 0
    (1..k).forEach {
        ans = numStr.map { it - '0' }.sum()
        numStr = ans.toString()
    }


    return ans
}
