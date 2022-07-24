/**
 * Brute force.
 */
fun equalPairs(grid: Array<IntArray>): Int {

    fun okay(i: Int, j: Int) = grid.indices.all { k -> grid[i][k] == grid[k][j] }
    return grid.indices.flatMap { i -> grid[0].indices.map { j -> i to j } }.count { (i, j) -> okay(i, j) }
}
