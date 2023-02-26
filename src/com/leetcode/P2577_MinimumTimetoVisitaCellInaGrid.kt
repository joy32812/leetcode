/**
 * special Dijkstra.
 */
fun minimumTime(grid: Array<IntArray>): Int {
    if (grid[1][0] > 1 && grid[0][1] > 1) return -1

    val dis = Array(grid.size) { IntArray(grid[0].size) { Int.MAX_VALUE } }
    val Q = ArrayDeque<Pair<Int, Int>>()
    val inQ = Array(grid.size) { BooleanArray(grid[0].size) }

    Q.add(0 to 0)
    inQ[0][0] = true
    dis[0][0] = 0

    while (Q.isNotEmpty()) {
        val (x, y) = Q.removeFirst()
        inQ[x][y] = false

        for ((dx, dy) in listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)) {
            val nx = x + dx
            val ny = y + dy

            if (nx in grid.indices && ny in grid[0].indices) {
                var newDis = dis[x][y] + 1
                if (newDis < grid[nx][ny]) {
                    val diff = grid[nx][ny] - newDis
                    if (diff % 2 == 0) {
                        newDis = grid[nx][ny]
                    } else {
                        newDis = grid[nx][ny] + 1
                    }
                }

                if (dis[nx][ny] > newDis) {
                    dis[nx][ny] = newDis

                    if (!inQ[nx][ny]) {
                        Q.add(nx to ny)
                        inQ[nx][ny] = true
                    }
                }
            }
        }
    }

    return dis[grid.size - 1][grid[0].size - 1]
}

