package com.leetcode

/**
 * sort by time needed.
 */
fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {

    class Monster(val d: Int, val s: Int)
    val monsters = dist.indices.map { Monster(dist[it], speed[it]) }.sortedWith(Comparator { o1, o2 ->
        when {
            1L * o1.d * o2.s < 1L * o2.d * o1.s -> -1
            1L * o1.d * o2.s > 1L * o2.d * o1.s -> 1
            else -> 0
        }
    })

    var ans = 1
    for (i in 1 until monsters.size) {
        if (1L * monsters[i].s * i >= monsters[i].d) break
        ans ++
    }

    return ans
}

