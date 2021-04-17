package com.leetcode

/**
 * Josephus Problem
 */
fun findTheWinner(n: Int, k: Int): Int {

    var cur = 0
    val list = (1..n).map { it }.toMutableList()
    fun findIndex(k: Int) {
        var cnt = k
        while (cnt > 0) {
            if (list[cur] != 0) {
                cnt --
                if (cnt == 0) break
            }
            cur ++
            if (cur == list.size) cur = 0
        }
    }

    for (i in 1 until n) {
        findIndex(k)
        list[cur] = 0
    }

    return list.first { it != 0 }
}

fun main() {
    println(findTheWinner(5, 2))
}
