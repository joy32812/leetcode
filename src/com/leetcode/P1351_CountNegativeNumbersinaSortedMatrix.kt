package com.leetcode

fun countNegatives(grid: Array<IntArray>): Int {
    return grid.flatMap { it.toList() }.count { it < 0 }
}


fun countNegatives2(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size

    var i = 0
    var j = n - 1

    var ans = 0
    while (i < m && j >= 0) {
        if (grid[i][j] < 0) {
            ans += m - i
            j--
        } else {
            i++
        }
    }
    return ans
}