import java.util.LinkedList

/**
 * Topological sort.
 */
fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {

    fun possibleList(conditions: Array<IntArray>): List<Int> {
        val inDeg = IntArray(k + 1) { 0 }
        val edgeMap = mutableMapOf<Int, MutableSet<Int>>()

        for ((l, r) in conditions) {
            val edgeSet = edgeMap.getOrPut(l) { mutableSetOf() }
            if (r !in edgeSet) {
                inDeg[r]++
                edgeMap.getOrPut(l) { mutableSetOf() } += r
            }
        }

        val Q = LinkedList<Int>()
        for (i in 1..k) {
            if (inDeg[i] == 0) Q.add(i)
        }

        val ans = mutableListOf<Int>()
        while (Q.isNotEmpty()) {
            val u = Q.poll()
            ans += u
            val edges = edgeMap[u] ?: continue

            for (v in edges) {
                inDeg[v]--
                if (inDeg[v] == 0) Q.add(v)
            }
        }

        if (inDeg.any { it != 0 }) return emptyList()
        val ansSet = ans.toSet()

        for (i in 1..k) {
            if (i in ansSet) continue
            ans += i
        }

        return ans
    }

    val rowList = possibleList(rowConditions)
    val colList = possibleList(colConditions)
    if (rowList.isEmpty() || colList.isEmpty()) return emptyArray()

    val ans = Array(k) { IntArray(k) { 0 } }

    val rowMap = rowList.withIndex().associate { it.value to it.index }
    val colMap = colList.withIndex().associate { it.value to it.index }

    for (i in 1..k) {
        ans[rowMap[i]!!][colMap[i]!!] = i
    }

    return ans
}
