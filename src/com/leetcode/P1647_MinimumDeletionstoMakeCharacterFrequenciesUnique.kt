package com.leetcode

/**
 * greedy
 * 1. count and sort
 * 2. from high to low. find out the max freq number it can be
 */
fun minDeletions(s: String): Int {

    val count = s.groupBy { it }.values.map { it.size }.sorted()
    if (count.size <= 1) return 0

    var ans = 0
    var now = count.last()
    for (i in count.size - 2 downTo 0) {
        now --
        if (now < 0) now = 0
        if (count[i] > now) ans += count[i] - now
        else now = count[i]
    }

    return ans
}

fun main() {
    println(minDeletions("bbcebab"))
}
