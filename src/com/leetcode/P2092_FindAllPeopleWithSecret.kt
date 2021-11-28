package com.leetcode

/**
 * DFS by group.
 */
fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {

    val times = meetings.map { it[2] }.toSortedSet()
    val groupBy = meetings.groupBy { it[2] }

    val colors = Array(n + 1) { -1 }
    colors[firstPerson] = 0
    colors[0] = 0

    for (t in times) {
        val people = mutableSetOf<Int>()

        val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
        groupBy[t]!!.forEach {
            edgeMap.getOrPut(it[0]) { mutableSetOf() } += it[1]
            edgeMap.getOrPut(it[1]) { mutableSetOf() } += it[0]
            people += it[0]
            people += it[1]
        }

        val visited = mutableSetOf<Int>()
        fun dfs(x: Int) {
            if (x in visited) return
            visited += x
            colors[x] = 0
            for (y in (edgeMap[x] ?: mutableSetOf())) {
                dfs(y)
            }
        }

        people.forEach { if (colors[it] == 0) dfs(it) }
    }

    return (0..n).filter { colors[it] == 0 }
}
