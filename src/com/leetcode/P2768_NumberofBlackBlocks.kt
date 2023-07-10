fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {

    val posMap = mutableMapOf<Long, Int>()
    for ((x, y) in coordinates) {
        for (i in x - 1 .. x) {
            for (j in y - 1 .. y) {
                if (i < 0 || i >= m - 1 || j < 0 || j >= n - 1) continue
                val key = 1L * i * n + j
                posMap[key] = (posMap[key] ?: 0) + 1
            }
        }
    }

    val ans = LongArray(5)
    ans[0] = 1L * (m - 1) * (n - 1) - posMap.size

    for ((_, v) in posMap) ans[v]++
    return ans
}

fun main() {
    // m = 3, n = 3, coordinates = [[0,0],[1,1],[0,2]]
    println(countBlackBlocks(
        3, 3, arrayOf(
            intArrayOf(0,0),
            intArrayOf(1,1),
            intArrayOf(0,2)
        )
    ).toList())
}
