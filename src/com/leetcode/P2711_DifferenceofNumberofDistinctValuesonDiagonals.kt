/**
 * brute force.
 */
fun differenceOfDistinctValues(grid: Array<IntArray>): Array<IntArray> {
    val m = grid.size
    val n = grid[0].size

    fun getTopLeftDiagonalUniqueCnt(r: Int, c: Int): Int {

        val set = mutableSetOf<Int>()
        var i = r - 1
        var j = c - 1
        while (i >= 0 && j >= 0) {
            set.add(grid[i][j])
            i--
            j--
        }
        return set.size

    }

    fun getBottomRightDiaonalUniqueCnt(r: Int, c: Int): Int {
        val set = mutableSetOf<Int>()
        var i = r + 1
        var j = c + 1
        while (i < m && j < n) {
            set.add(grid[i][j])
            i++
            j++
        }
        return set.size
    }

    fun getCell(r: Int, c: Int): Int {

        return Math.abs(
            getTopLeftDiagonalUniqueCnt(r, c) - getBottomRightDiaonalUniqueCnt(r, c)
        )

    }

    val ans = Array(m) { IntArray(n) }
    for (r in grid.indices) {

        for (c in grid[0].indices) {

            ans[r][c] = getCell(r, c)

        }

    }

    return ans
}
