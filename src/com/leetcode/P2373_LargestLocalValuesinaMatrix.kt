/**
 * easy
 */
fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    val n = grid.size
    val m = grid[0].size

    val ans = Array(n - 2) { IntArray(m - 2) }

    fun findMax(x: Int, y: Int): Int {
        var max = Int.MIN_VALUE
        for (i in x - 1 .. x + 1) {
            for (j in y - 1 .. y + 1) {
                max = maxOf(max, grid[i][j])
            }
        }
        return max
    }

    for (i in 1 until n - 1) {
        for (j in 1 until m - 1) {
            ans[i - 1][j - 1] = findMax(i, j)
        }
    }

    return ans
}
