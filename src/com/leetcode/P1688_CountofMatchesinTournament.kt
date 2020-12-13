package com.leetcode

/**
 * https://leetcode.com/problems/count-of-matches-in-tournament/discuss/970311/Just-return-n-1-O(1)
 */
fun numberOfMatches2(n: Int): Int {
    return n - 1
}

fun numberOfMatches(n: Int): Int {
    var ans = 0
    var num = n
    while (num > 1) {
        ans += num / 2
        num = (num + 1) / 2
    }
    return ans
}

fun main() {
    println("Hello")
}
