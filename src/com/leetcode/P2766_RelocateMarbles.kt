fun relocateMarbles(nums: IntArray, moveFrom: IntArray, moveTo: IntArray): List<Int> {

    val posMap = nums.groupBy { it }.mapValues { it.value.size }.toMutableMap()

    fun move(from: Int, to: Int) {
        val fromCount = posMap[from]!!
        posMap[to] = (posMap[to] ?: 0) + fromCount
        posMap.remove(from)
    }

    for (i in moveFrom.indices) {
        val from = moveFrom[i]
        val to = moveTo[i]

        if (from in posMap && from != to) {
            move(from, to)
        }
    }

    return posMap.keys.sorted()
}

fun main() {
    // [3,4]
    // [4,3,1,2,2,3,2,4,1]
    // [3,1,2,2,3,2,4,1,1]
    println(
        relocateMarbles(
            intArrayOf(3,4),
            intArrayOf(4,3,1,2,2,3,2,4,1),
            intArrayOf(3,1,2,2,3,2,4,1,1)
        )
    )
}
