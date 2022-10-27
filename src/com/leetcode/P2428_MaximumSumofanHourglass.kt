/**
 * brute force.
 */
fun maxSum(grid: Array<IntArray>): Int {

    val m = grid.size
    val n = grid[0].size

    var ans = 0
    for (i in 1 until m - 1) {

        for (j in 1 until n - 1) {

            var sum = 0
            for (k in 0..2) {
                sum += grid[i - 1][j - 1 + k]
                sum += grid[i + 1][j - 1 + k]
            }
            sum += grid[i][j]
            ans = Math.max(ans, sum)
        }
    }

    return ans
}
