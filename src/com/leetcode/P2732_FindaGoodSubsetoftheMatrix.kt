fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {

    val m = grid.size
    val n = grid[0].size

    val map = mutableMapOf<Int, Int>()

    fun IntArray.toInt() = this.joinToString("") { it.toString() }.toInt(2)

    fun okay(x: Int, y: Int): Boolean {

        for (k in 0 until n) {
            if (x and (1 shl k) != 0 && y and (1 shl k) != 0) return false
        }

        return true

    }

    for (i in 0 until m) {
        val x = grid[i].toInt()
        if (x == 0) return listOf(i)

        for (y in 0 until (1 shl n)) {
            if (y in map && okay(x, y)) return listOf(map[y]!!, i)
        }

        map[x] = i
    }


    return emptyList()
}

fun main() {
    // grid = [[0,1,1,0],[0,0,0,1],[1,1,1,1]]
    println(goodSubsetofBinaryMatrix(
        arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 0, 1),
            intArrayOf(1, 1, 1, 1)
        )
    ))
}
