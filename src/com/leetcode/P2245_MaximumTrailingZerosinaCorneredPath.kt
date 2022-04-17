package com.leetcode

/**
 * Prefix sum.
 * top-down && bottom-up.
 */
fun maxTrailingZeros(grid: Array<IntArray>): Int {

    class NumNode(var two: Int, var five: Int, var ten: Int)

    fun getNum(x: Int): NumNode {
        val res = NumNode(0, 0, 0)
        var x = x

        while (x % 10 == 0) {
            res.ten ++
            x /= 10
        }

        while (x % 2 == 0) {
            res.two ++
            x /= 2
        }

        while (x % 5 == 0) {
            res.five++
            x /= 5
        }
        return res
    }

    fun fromLeft(arr: IntArray): List<NumNode> {
        val ans = mutableListOf<NumNode>()
        var last = NumNode(0, 0, 0)
        for (d in arr) {
            val now = getNum(d)
            now.two += last.two
            now.five += last.five
            now.ten += last.ten

            ans += now
            last = now
        }

        return ans
    }

    fun getNodeSum(node1: NumNode, node2: NumNode) = NumNode(
        node1.two + node2.two,
        node1.five + node2.five,
        node1.ten + node2.ten
    )
    fun getZeroNum(node: NumNode) = node.ten + Math.min(node.two, node.five)

    var ans = 0

    fun getAns(bottomUp: Boolean) {
        val lastRow = Array(grid[0].size) { NumNode(0, 0, 0) }
        val indices = if (bottomUp) grid.indices.reversed() else grid.indices

        for (i in indices) {

            val left = fromLeft(grid[i])
            for (j in grid[i].indices) {
                val total = getZeroNum(getNodeSum(left[j], lastRow[j]))
                ans = Math.max(ans, total)
            }

            val right = fromLeft(grid[i].reversedArray()).reversed()
            for (j in grid[i].indices) {
                val total = getZeroNum(getNodeSum(right[j], lastRow[j]))
                ans = Math.max(ans, total)
            }

            for (j in grid[i].indices) {
                val now = getNum(grid[i][j])
                lastRow[j].two += now.two
                lastRow[j].five += now.five
                lastRow[j].ten += now.ten
            }

        }
    }

    getAns(false)
    getAns(true)


    return ans
}

fun main() {
    println(maxTrailingZeros(
        arrayOf(
            intArrayOf(534,575,625,84,20,999,35),
            intArrayOf(208,318,96,380,819,102,669)
        )
    ))

}
