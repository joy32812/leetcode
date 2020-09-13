package com.leetcode

/**
 * easy
 * use array map to store the order for each person
 * and check
 */
fun unhappyFriends(n: Int, preferences: Array<IntArray>, pairs: Array<IntArray>): Int {

    val preArrayMap = preferences.map { pre -> pre.toList().zip(n downTo 2).toMap() }

    fun okay(x: Int, y: Int, u: Int, v: Int): Boolean {
        return preArrayMap[x][u]!! > preArrayMap[x][y]!! && preArrayMap[u][x]!! > preArrayMap[u][v]!!
    }

    var ans = 0
    for (i in pairs.indices) {
        val (x, y) = pairs[i]

        var unhappyX = false
        var unhappyY = false

        for (j in pairs.indices) {
            if (i == j) continue
            val (u, v) = pairs[j]
            if (okay(x, y, u, v) || okay(x, y, v, u)) unhappyX = true
            if (okay(y, x, u, v) || okay(y, x, v, u)) unhappyY = true
        }

        if (unhappyX) ans ++
        if (unhappyY) ans ++
    }

    return ans
}

fun main() {
    println(unhappyFriends(4,
            arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(3, 2, 0),
                    intArrayOf(3, 1, 0),
                    intArrayOf(1, 2, 0)
            ),
            arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(2, 3)
            )
    ))
}
