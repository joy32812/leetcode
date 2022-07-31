/**
 * Use sum to check.
 */
fun countSquares(matrix: Array<IntArray>): Int {
    val n = matrix.size
    val m = matrix[0].size

    val sum = Array(n) { IntArray(m) { 0 } }
    fun S(x: Int, y: Int) = if (x < 0 || y < 0) 0 else sum[x][y]

    for (i in 0 until n) {
        for (j in 0 until m) {
            sum[i][j] = S(i - 1, j) + S(i, j - 1) - S(i - 1, j - 1) + matrix[i][j]
        }
    }

    fun getSum(x1: Int, y1: Int, x2: Int, y2: Int) = S(x2, y2) - S(x1 - 1, y2) - S(x2, y1 - 1) + S(x1 - 1, y1 - 1)

    var count = 0
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) continue
            for (k in 1..minOf(i + 1, j + 1)) {
                if (getSum(i + 1 - k, j + 1 - k, i, j) == k * k) {
                    count ++
                } else break
            }
        }
    }

    return count
}

