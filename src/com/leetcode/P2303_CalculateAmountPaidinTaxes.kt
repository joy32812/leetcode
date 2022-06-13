package com.leetcode

/**
 * easy
 */
fun calculateTax(brackets: Array<IntArray>, income: Int): Double {

    var ans = 0.0
    var last = 0

    for ((u, p) in brackets) {
        if (income <= u) {
            ans += (income - last) * p / 100.0
            break
        }
        ans += (u - last) * p / 100.0
        last = u
    }

    return ans
}

