import java.util.*

fun leftmostBuildingQueries(heights: IntArray, queries: Array<IntArray>): IntArray {

    val gp = queries.map { (a, b) ->
        if (a > b) b to a
        else a to b
    }
        .distinct()
        .groupBy { it.second }
        .mapValues { (_, v) -> v.map { it.first } }

    val ansMap = mutableMapOf<Pair<Int, Int>, Int>()

    val treeMap = TreeMap<Int, Int>()
    for (i in heights.indices.reversed()) {
        val h = heights[i]

        while (treeMap.isNotEmpty() && treeMap.firstKey() <= h) {
            treeMap.remove(treeMap.firstKey())
        }
        treeMap[h] = i

        val gpList = gp[i] ?: emptyList()
        for (l in gpList) {
            if (treeMap.lastKey() <= heights[l]) {
                ansMap[l to i] = -1
                continue
            }

            val ceiling = treeMap.ceilingEntry(heights[l] + 1)
            ansMap[l to i] = ceiling?.value ?: -1
        }
    }


    return queries.map { (a, b) ->
        if (a == b) return@map a

        val pair = if (a > b) b to a else a to b
        ansMap[pair] ?: -1
    }.toIntArray()
}
