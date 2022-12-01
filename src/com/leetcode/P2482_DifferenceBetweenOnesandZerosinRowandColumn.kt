/**
 * easy.
 */
fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
    val m = grid.size
    val n = grid[0].size

    val oneRow = Array(m) { 0 }
    val zeroRow = Array(m) { 0 }

    val oneCol = Array(n) { 0 }
    val zeroCol = Array(n) { 0 }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                oneRow[i]++
                oneCol[j]++
            } else {
                zeroRow[i]++
                zeroCol[j]++
            }
        }
    }

    val result = Array(m) { IntArray(n) }
    for (i in 0 until m) {
        for (j in 0 until n) {
            result[i][j] = oneRow[i] + oneCol[j] - zeroRow[i] - zeroCol[j]
        }
    }

    return result

}
