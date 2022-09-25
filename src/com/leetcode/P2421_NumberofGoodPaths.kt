/**
 * union find
 */
fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {

    val gp = vals.withIndex()
        .groupBy { it.value }
        .mapValues { it.value.map { it.index } }
        .toSortedMap()

    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    for ((s, e) in edges) {
        edgeMap.getOrPut(s) { mutableSetOf() }.add(e)
        edgeMap.getOrPut(e) { mutableSetOf() }.add(s)
    }

    val fathers = Array(vals.size) { -1 }

    fun find(x: Int): Int {
        if (fathers[x] == x) return x
        fathers[x] = find(fathers[x])
        return fathers[x]
    }

    fun add(x: Int) {
        if (fathers[x] == -1) fathers[x] = x

        val toSet = edgeMap[x] ?: mutableSetOf()
        for (t in toSet) {
            if (fathers[t] == -1) continue

            val fx = find(x)
            val ft = find(t)
            fathers[fx] = ft
        }
    }

    var ans = 0
    for ((v, nodes) in gp) {
        nodes.forEach { add(it) }

        ans += nodes.map { find(it) }.groupBy { it }.mapValues { it.value.size }.map {
            it.value * (it.value - 1) / 2
        }.sum()
    }

    return ans + vals.size
}

