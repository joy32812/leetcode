package com.leetcode

/**
 * Memo DP
 */
fun hasValidPath(grid: Array<CharArray>): Boolean {
    val m = grid.size
    val n = grid[0].size
    if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false

    val ansMap = HashMap<String, Boolean>()

    fun okay(x: Int, y: Int, expect: Int): Boolean {
        if (x < 0 || x >= m || y < 0 || y >= n) return false
        if (expect < 0) return false

        val key = "$x,$y,$expect"
        if (key in ansMap) return ansMap[key]!!

        val newExpect = expect + if (grid[x][y] == '(') -1 else 1
        if (x == 0 && y == 0 && newExpect == 0) return true

        val res = okay(x - 1, y, newExpect) || okay(x, y - 1, newExpect)
        ansMap[key] = res

        return res
    }


    return okay(m -1, n - 1, 0)

}
