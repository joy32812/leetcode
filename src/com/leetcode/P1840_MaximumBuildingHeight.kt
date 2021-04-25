package com.leetcode

fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
    val buildings = restrictions.toMutableList()
    buildings += intArrayOf(1, 0)
    buildings += intArrayOf(n, 1_000_000_000)
    buildings.sortBy { it[0] }

    for (i in 0 until buildings.size - 1) {
        buildings[i + 1][1] = Math.min(buildings[i + 1][1], buildings[i][1] + buildings[i + 1][0] - buildings[i][0])
    }

    for (i in buildings.size - 1 downTo 1) {
        buildings[i - 1][1] = Math.min(buildings[i - 1][1], buildings[i][1] + buildings[i][0] - buildings[i - 1][0])
    }

    var ans = 0
    for (i in 0 until buildings.size - 1) {
        val (p1, h1) = buildings[i]
        val (p2, h2) = buildings[i + 1]
        val tmp = (Math.abs(p1 - p2) - Math.abs(h1 - h2)) / 2 + Math.max(h1, h2)
        ans = Math.max(ans, tmp);
    }

    return ans
}
