package com.leetcode

import java.util.*

/**
 * line sweep
 */
fun fullBloomFlowers(flowers: Array<IntArray>, persons: IntArray): IntArray {

    data class Flower(val pos: Int, val isStart: Boolean)

    val flowerList = flowers.flatMap {
        listOf(
            Flower(it[0], true), Flower(it[1] + 1, false)
        )
    }.sortedBy { it.pos }

    var now = 0
    val treeMap = TreeMap<Int, Int>()
    treeMap[0] = 0
    for ((pos, isStart) in flowerList) {

        if (isStart) now++
        else now--

        treeMap[pos] = now
    }

    return persons.map { treeMap.floorEntry(it).value }.toIntArray()
}
