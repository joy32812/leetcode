package com.leetcode

/**
 * union find
 */
fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
    val dx = mutableListOf(0, 0, 1, -1)
    val dy = mutableListOf(1, -1, 0, 0)

    val n = row * col
    val father = Array(n) { -1 }
    (0 until n).forEach { father[it] = it }

    val mat = Array(row) { Array(col) { 1 } }

    fun getFather(v: Int): Int {
        if (father[v] == v) return v

        father[v] = getFather(father[v])
        return father[v]
    }

    fun connect(): Boolean {
        val fatherTop = (0 until col).map { getFather(it) }.toSet()
        val fatherBottom = (0 until col).map { getFather((row - 1) * col + it) }.toSet()

        return fatherTop.intersect(fatherBottom).isNotEmpty()
    }

    for (i in cells.indices.reversed()) {
        var (x, y) = cells[i]
        x --
        y --
        mat[x][y] = 0

        for (k in dx.indices) {
            val tx = x + dx[k]
            val ty = y + dy[k]

            if (tx < 0 || tx >= row || ty < 0 || ty >= col || mat[tx][ty] == 1) continue

            val fk = getFather(tx * col + ty)
            father[fk] = x * col + y
        }

        if (connect()) return i
    }

    return -1
}
