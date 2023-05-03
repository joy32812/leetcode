fun findMaxFish(grid: Array<IntArray>): Int {

    val m = grid.size
    val n = grid[0].size

    val visited = Array(m) { BooleanArray(n) }

    var ans = 0

    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    fun collectFish(fx: Int, fy: Int): Int {
        var fish = 0

        fun dfs(x: Int, y: Int) {
            visited[x][y] = true
            fish += grid[x][y]

            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx in 0 until m && ny in 0 until n && !visited[nx][ny] && grid[nx][ny] != 0) {
                    dfs(nx, ny)
                }
            }
        }

        dfs(fx, fy)
        return fish
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (visited[i][j]) continue
            if (grid[i][j] == 0) continue

            ans = maxOf(ans, collectFish(i, j))
        }
    }

    return ans
}
