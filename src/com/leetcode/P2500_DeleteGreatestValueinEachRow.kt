/**
 * sumOf
 */
fun deleteGreatestValue(grid: Array<IntArray>): Int {

    grid.forEach { it.sortDescending() }

    return grid[0].indices.sumOf { j ->
        grid.indices.maxOfOrNull { i -> grid[i][j] } ?: 0
    }
}
