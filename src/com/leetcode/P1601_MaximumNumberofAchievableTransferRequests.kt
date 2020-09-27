package com.leetcode

/**
 * bitmasking
 */
fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
    var ans = 0
    fun maxReq(x: Int): Int {
        val balance = Array(n) {0}
        val hasIndexs = requests.indices.filter { (x and (1 shl it)) > 0 }
        hasIndexs.forEach {
            balance[requests[it][0]] --
            balance[requests[it][1]] ++
        }

        return if (balance.all { it == 0 }) hasIndexs.size else 0
    }

    return (0 until (1 shl requests.size)).map { maxReq(it) }.max()!!
}

fun main() {
    val size = 2
    for (i in 0 until  (1 shl size)) {
        println(i)
    }
}
