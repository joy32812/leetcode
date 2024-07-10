fun numberOfSubmatrices(grid: Array<CharArray>): Int {
    val r = grid.size
    val c = grid[0].size

    val cntX = Array(r) { IntArray(c) }
    val cntY = Array(r) { IntArray(c) }

    var ans = 0

    for (i in 0 until r) {
        for (j in 0 until c) {
            // count of Xs between (0, 0) and (i, j)
            if (grid[i][j] == 'X') {
                cntX[i][j] = 1
            }
            if (i > 0) cntX[i][j] += cntX[i - 1][j]
            if (j > 0) cntX[i][j] += cntX[i][j - 1]
            if (i > 0 && j > 0) cntX[i][j] -= cntX[i - 1][j - 1]

            // count of Ys between (0, 0) and (i, j)
            if (grid[i][j] == 'Y') {
                cntY[i][j] = 1
            }
            if (i > 0) cntY[i][j] += cntY[i - 1][j]
            if (j > 0) cntY[i][j] += cntY[i][j - 1]
            if (i > 0 && j > 0) cntY[i][j] -= cntY[i - 1][j - 1]

            if (cntX[i][j] > 0 && cntX[i][j] == cntY[i][j]) ans++
        }
    }


    return ans
}
