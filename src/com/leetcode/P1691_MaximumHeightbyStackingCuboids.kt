package com.leetcode

/**
 * DP
 */
fun maxHeight(cuboids: Array<IntArray>): Int {

    val n = cuboids.size
    val indexMapping = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(0, 2, 1),
            intArrayOf(1, 0, 2),
            intArrayOf(1, 2, 0),
            intArrayOf(2, 0, 1),
            intArrayOf(2, 1, 0)
    )
    val used = Array(n) { false }
    val results = Array(6 * n) { 0 }

    fun okay(a: Int, b: Int): Boolean {
        val w1 = cuboids[a % n][indexMapping[a / n][0]]
        val l1 = cuboids[a % n][indexMapping[a / n][1]]
        val h1 = cuboids[a % n][indexMapping[a / n][2]]

        val w2 = cuboids[b % n][indexMapping[b / n][0]]
        val l2 = cuboids[b % n][indexMapping[b / n][1]]
        val h2 = cuboids[b % n][indexMapping[b / n][2]]

        return w1 >= w2 && l1 >= l2 && h1 >= h2
    }

    fun work(x: Int): Int {
        if (results[x] > 0) return results[x]
        used[x % n] = true

        var tmp = 0
        for (i in 0 until 6 * n) {
            if (!used[i % n] && okay(x, i)) {
                tmp = Math.max(tmp, work(i))
            }
        }
        used[x % n] = false

        results[x] = tmp + cuboids[x % n][indexMapping[x / n][2]]
        return results[x]
    }


    for (i in 0 until 6 * n) {
        work(i)
    }


    return results.max()!!
}


fun main() {
    println("Hello")
}
