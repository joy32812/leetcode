fun findColumnWidth(grid: Array<IntArray>): IntArray {

    val m = grid.size
    val n = grid[0].size

    fun getWidth(col: Int) = (0 until m).map { ("" + grid[it][col]).length }.maxOrNull()!!

    return (0 until n).map { getWidth(it) }.toIntArray()
}
