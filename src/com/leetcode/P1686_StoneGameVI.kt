package com.leetcode

fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {

    class Stone(val index: Int, val av: Int, val bv: Int)
    val stones = aliceValues.indices.map { Stone(it, aliceValues[it], bobValues[it]) }.sortedByDescending { it.av + it.bv }

    val aliceTotal = stones.mapIndexed { index, stone -> if (index % 2 == 0) stone.av else 0 }.sum()
    val bobTotal = stones.mapIndexed { index, stone -> if (index % 2 == 1) stone.bv else 0 }.sum()

    if (aliceTotal > bobTotal) return 1
    if (aliceTotal < bobTotal) return -1
    return 0
}
