package com.leetcode

fun findKthBit(n: Int, k: Int): Char {
    val cnts = Array(n + 1) { 0 }
    cnts[1] = 1
    (2..n).forEach { cnts[it] = 2 * cnts[it - 1] + 1 }

    fun dfs(a: Int, b: Int): Int {
        if (a == 1) return 0
        val len = cnts[a]
        if (b * 2 == len + 1) return 1
        if (b * 2 < len + 1) return dfs(a - 1, b)

        return 1 - dfs(a - 1, len + 1 - b)
    }

    return '0' + dfs(n, k)
}

fun main() {
    println(findKthBit(3, 5))
}
