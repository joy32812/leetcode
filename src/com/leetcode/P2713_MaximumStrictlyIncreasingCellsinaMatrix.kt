
private data class Cell(val row: Int, val col: Int, val value: Int)

/**
 * Sort the cells by value, and then use DP to find the longest increasing subsequence.
 */
fun maxIncreasingCells(mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size

    val rowMaxs = Array(m) { 0 }
    val colMaxs = Array(n) { 0 }
    val dp = Array(m) { IntArray(n) { 0 } }

    val cells = mutableListOf<Cell>()
    for (r in 0 until m) {
        for (c in 0 until n) {
            cells += Cell(r, c, mat[r][c])
        }
    }


    val gp = cells.groupBy { it.value }

    for (key in gp.keys.sorted()) {
        val list = gp[key]!!

        for ((r, c, v) in list) {
            dp[r][c] = 1 + maxOf(rowMaxs[r], colMaxs[c])
        }

        for ((r, c, v) in list) {
            rowMaxs[r] = maxOf(rowMaxs[r], dp[r][c])
            colMaxs[c] = maxOf(colMaxs[c], dp[r][c])
        }
    }

    return dp.flatMap { it.asIterable() }.maxOrNull()!!
}

fun main() {
    // [[3,1],[3,4]]
    println(maxIncreasingCells(arrayOf(intArrayOf(3, 1), intArrayOf(3, 4))))
}
