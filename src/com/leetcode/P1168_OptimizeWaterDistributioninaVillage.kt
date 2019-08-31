package com.leetcode


/**
 * MST
 */
fun minCostToSupplyWater(n: Int, wells: IntArray, pipes: Array<IntArray>): Int {

    data class Dist(val s: Int, val t: Int, val dis: Int)
    val edges = mutableListOf<Dist>()

    wells.forEachIndexed { index, d -> edges += Dist(0, index + 1, d) }
    pipes.forEach { edges += Dist(it[0], it[1], it[2]) }
    edges.sortBy { it.dis }


    val fatherMap = mutableMapOf<Int, Int>()
    fun getFather(s: Int): Int {
        if (s !in fatherMap) return s

        fatherMap[s] = getFather(fatherMap[s]!!)
        return fatherMap[s]!!
    }

    var ans = 0
    edges.forEach {
        val (s, t, dis) = it
        val fs = getFather(s)
        val ft = getFather(t)

        if (fs != ft) {
            ans += dis
            fatherMap[fs] = ft
        }
    }

    return ans
}

