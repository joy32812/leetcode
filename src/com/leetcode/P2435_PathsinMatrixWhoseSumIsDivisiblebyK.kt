/**
 * Classic dp.
 */
fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
    val MOD = 1000000007
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { Array(n) { IntArray(k + 1) } }

    fun checkPathFrom(fx: Int, fy: Int, i: Int, j: Int) {
        for (x in 0 until k) {
            dp[i][j][(x + grid[i][j]) % k] = (dp[i][j][(x + grid[i][j]) % k] + dp[fx][fy][x]) % MOD
        }
    }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (i == 0 && j == 0) {
                dp[i][j][grid[i][j] % k] = 1
                continue
            }

            // i - 1, j
            if (i - 1 >= 0) checkPathFrom(i - 1, j, i, j)

            // i, j - 1
            if (j - 1 >= 0) checkPathFrom(i, j - 1, i, j)
        }
    }

    return dp[m - 1][n - 1][0]
}
