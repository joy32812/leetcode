package com.leetcode

fun mostVisited(n: Int, rounds: IntArray): List<Int> {
    val visits = Array(n + 1) { 0 }
    var cur = rounds[0]
    var i = 1
    while (i < rounds.size) {
        if (cur == rounds[i]) i++
        visits[cur] ++
        cur ++
        if (cur == n + 1) cur = 1
    }

    val max = visits.max()!!
    return (1..n).filter { visits[it] == max }.toList()
}

fun main() {
    println(mostVisited(4, intArrayOf(1, 3, 1, 2)))
}
