/**
 * dp.
 */
fun minimumTotalDistance2(robot: List<Int>, factory: Array<IntArray>): Long {
    val R = robot.sorted()
    val F = factory.sortedBy { it[0] }

    val total = factory.map { it[1] }.sum()

    val m = R.size
    val n = F.size

    val dp = Array(101) { Array(101) { Array(101) { Long.MAX_VALUE } } }

    fun dfs(x: Int, y: Int, k: Int, total: Int): Long {
        if (x == m) return 0
        if (y == n) return Long.MAX_VALUE / 2
        if (m - x > total) return Long.MAX_VALUE / 2

        if (dp[x][y][k] != Long.MAX_VALUE) return dp[x][y][k]

        var ans = Long.MAX_VALUE / 2
        var cur = total
        var last = Long.MAX_VALUE
        for (i in y until n) {

            val from = if (i == y) k else 0

            for (j in from until F[i][1]) {

                val dis = Math.abs(0L + R[x] - F[i][0])
                if (dis >= last) break
                last = dis

                ans = minOf(ans, dis + dfs(x + 1, i, j + 1, cur))
                cur --

            }
        }

        dp[x][y][k] = ans
        return ans
    }

    return dfs(0, 0, 0, total)
}

