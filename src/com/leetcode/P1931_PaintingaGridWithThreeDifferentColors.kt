package com.leetcode

import kotlin.math.roundToInt

/**
 * dp state compression
 */
fun colorTheGrid(m: Int, n: Int): Int {
    val MOD = 1_000_000_000 + 7

    var dpMap = mutableMapOf<Int, Long>()
    val okSet = mutableSetOf<Int>()
    val okayPairSet = mutableSetOf<String>()
    val colSum = Math.pow(3.0, .0 + m).roundToInt()



    fun getList(x: Int): List<Int> {
        var color = x
        val list = mutableListOf<Int>()

        for (i in 0 until m) {
            list += color % 3
            color /= 3
        }

        return list
    }

    fun okColor(color: Int): Boolean {
        return getList(color).zipWithNext().none { it.first == it.second }
    }

    fun okayPair(x: Int, y: Int): Boolean {
        val color1 = getList(x)
        val color2 = getList(y)

        return (0 until m).none { color1[it] == color2[it] }
    }



    for (j in 0 until colSum) {
        if (okColor(j)) {
            okSet += j
            dpMap[j] = 1
        }
    }

    for (j in okSet) {
        for (k in okSet) {
            if (okayPair(j, k)) okayPairSet += "" + j + "_" + k
        }
    }

    for (i in 1 until n) {
        val tmpMap = mutableMapOf<Int, Long>()

        for (j in okSet) {
            tmpMap[j] = 0
            for (k in okSet) {
                val key = "" + j + "_" + k
                if (key in okayPairSet) tmpMap[j] = (tmpMap[j]!! + dpMap[k]!!) % MOD
            }
        }

        dpMap = tmpMap
    }


    return (dpMap.values.sum() % MOD).toInt()
}

fun main() {
    println(colorTheGrid(1, 1))
}
