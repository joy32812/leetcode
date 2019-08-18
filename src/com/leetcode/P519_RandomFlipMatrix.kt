package com.leetcode

import kotlin.random.Random.Default.nextInt

class P519_RandomFlipMatrix(n_rows: Int, n_cols: Int) {

    val row = n_rows
    val col = n_cols

    var total = row * col
    var map = mutableMapOf<Int, Int>()

    fun flip(): IntArray {
        val r = nextInt(total)
        val now = map[r] ?: r

        total--
        map[r] = map[total] ?: total

        return intArrayOf(now / col, now % col)
    }

    fun reset() {
        total = row * col
        map = mutableMapOf()
    }
}

fun main() {

    val obj = P519_RandomFlipMatrix(2, 2)

    for (i in 0..3) {
        println(obj.flip().joinToString())
    }


}

