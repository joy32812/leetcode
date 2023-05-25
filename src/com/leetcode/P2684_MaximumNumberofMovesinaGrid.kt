fun maxMoves(grid: Array<IntArray>): Int {

    val m = grid.size
    val n = grid[0].size

    val dp = Array(m) { IntArray(n) { -1 } }
    for (i in 0 until m) dp[i][0] = 0

    fun getFrom(x1: Int, y1: Int, x2: Int, y2: Int): Int {
        if (x2 !in 0 until m || y2 !in 0 until n) return -1
        if (grid[x1][y1] <= grid[x2][y2]) return -1
        if (dp[x2][y2] == -1) return -1

        return dp[x2][y2] + 1
    }

    var ans = 0
    for (j in 1 until n) {
        for (i in 0 until m) {
            dp[i][j] = maxOf(
                getFrom(i, j, i - 1, j - 1),
                getFrom(i, j, i, j - 1),
                getFrom(i, j, i + 1, j - 1)
            )

            ans = maxOf(ans, dp[i][j])
        }
    }

    return ans
}

fun main() {
    // grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
    println(
        maxMoves(
            arrayOf(
                intArrayOf(2, 4, 3, 5),
                intArrayOf(5, 4, 9, 3),
                intArrayOf(3, 4, 2, 11),
                intArrayOf(10, 9, 13, 15)
            )
        )
    )
}
