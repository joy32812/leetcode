fun checkValidGrid(grid: Array<IntArray>): Boolean {

    // get all triplets (i, j, v)
    val triplets = mutableListOf<Triple<Int, Int, Int>>()
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            triplets.add(Triple(i, j, grid[i][j]))
        }
    }

    // sort triplets by value
    triplets.sortBy { it.third }

    var prev = triplets[0]
    if (prev.first != 0 || prev.second != 0 || prev.third != 0) return false

    for (i in 1 until triplets.size) {
        val curr = triplets[i]

        if (curr.third != prev.third + 1) return false

        val dx = Math.abs(curr.first - prev.first)
        val dy = Math.abs(curr.second - prev.second)

        if (setOf(dx, dy) != setOf(1, 2)) return false

        // update prev
        prev = curr
    }

    return true
}

