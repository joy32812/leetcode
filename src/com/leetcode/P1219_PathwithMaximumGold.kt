package com.leetcode


fun getMaximumGold(grid: Array<IntArray>): Int {

    val cellMap = mutableMapOf<Pair<Int, Int>, Int>()
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] > 0) {
                cellMap[Pair(i, j)] = grid[i][j]
            }
        }
    }

    var ans = 0
    val visit = mutableSetOf<Pair<Int, Int>>()

    fun adj(a: Pair<Int, Int>, b: Pair<Int, Int>): Boolean {
        return (a.first == b.first && Math.abs(a.second - b.second) == 1) || (a.second == b.second && Math.abs(a.first - b.first) == 1)
    }

    fun dfs(now: Pair<Int, Int>, current: Int) {
        ans = Math.max(ans, current)

        for (p in cellMap.keys) {
            if (p in visit) continue
            if (!adj(now, p)) continue

            visit += p

            dfs(p, current + cellMap[p]!!)

            visit -= p
        }

    }

    for (p in cellMap.keys) {
        visit += p
        dfs(p, cellMap[p]!!)
        visit -= p
    }

    return ans
}



fun main() {

    println("Hello, World! 333")

}
