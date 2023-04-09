/**
 * BFS with Skip ahead.
 */
fun minimumVisitedCells(grid: Array<IntArray>): Int {

    val m = grid.size
    val n = grid[0].size

    val rowMaxs = IntArray(m) { 0 }
    val colMaxs = IntArray(n) { 0 }

    val dist = Array(m) { IntArray(n) { Int.MAX_VALUE } }.apply { this[0][0] = 1 }
    var Q = mutableSetOf<Pair<Int, Int>>().apply { add(0 to 0) }

    while (Q.isNotEmpty()) {

        val nextQ = mutableSetOf<Pair<Int, Int>>()

        for ((i, j) in Q) {

            // row
            val minRow = maxOf(j + 1, rowMaxs[i] + 1)
            val maxRow = minOf(j + grid[i][j], n - 1)
            for (k in minRow .. maxRow) {
                if (dist[i][k] != Int.MAX_VALUE) continue

                dist[i][k] = dist[i][j] + 1
                nextQ.add(i to k)
            }
            rowMaxs[i] = maxOf(rowMaxs[i], maxRow)

            // col
            val minCol = maxOf(i + 1, colMaxs[j] + 1)
            val maxCol = minOf(i + grid[i][j], m - 1)
            for (k in minCol .. maxCol) {
                if (dist[k][j] != Int.MAX_VALUE) continue

                dist[k][j] = dist[i][j] + 1
                nextQ.add(k to j)
            }
            colMaxs[j] = maxOf(colMaxs[j], maxCol)

        }

        Q = nextQ
    }

    return if (dist[m - 1][n - 1] == Int.MAX_VALUE) return -1 else dist[m - 1][n - 1]
}

