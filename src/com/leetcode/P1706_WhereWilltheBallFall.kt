package com.leetcode

fun findBall(grid: Array<IntArray>): IntArray {
    val m = grid.size
    val n = grid[0].size

    fun gogogo(col: Int): Int {
        var y = col
        for (x in 0 until m) {
            if (grid[x][y] == 1) {
                if (y + 1 >= n || grid[x][y + 1] == -1) return -1
                y ++
            } else {
                if (y - 1 < 0 || grid[x][y - 1] == 1) return -1
                y --
            }
        }
        return y
    }

    return (0 until n).map { gogogo(it) }.toIntArray()
}

fun main() {
    println("Hello")
}
