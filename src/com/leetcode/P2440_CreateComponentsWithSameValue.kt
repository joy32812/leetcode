import java.util.*

/**
 * toplogical-sort-like.
 */
fun componentValue(nums: IntArray, edges: Array<IntArray>): Int {
    val sum = nums.sum()
    val max = nums.maxOrNull()!!

    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    for (edge in edges) {
        edgeMap.getOrPut(edge[0]) { mutableSetOf() }.add(edge[1])
        edgeMap.getOrPut(edge[1]) { mutableSetOf() }.add(edge[0])
    }


    fun okay(x: Int): Boolean {
        if (sum % x != 0) return false

        val each = sum / x
        if (each < max) return false

        val now = nums.toMutableList()

        val degrees = IntArray(nums.size)
        for (edge in edges) {
            degrees[edge[0]]++
            degrees[edge[1]]++
        }

        val pq = PriorityQueue<Int>()
        for (i in nums.indices) {
            if (degrees[i] == 1) {
                pq.add(i)
            }
        }

        val removed = mutableSetOf<Int>()
        fun remove(z: Int) {
            removed += z

            for (y in edgeMap[z]!!) {
                if (y in removed) continue

                degrees[y]--
                if (degrees[y] <= 1) {
                    pq.add(y)
                }
            }
        }

        while (pq.isNotEmpty()) {
            val u = pq.poll()

            if (u in removed) continue
            if (now[u] > each) return false

            if (now[u] < each) {
                val v = edgeMap[u]!!.first { it !in removed }
                now[v] += now[u]
            }

            remove(u)
        }

        return true
    }

    return (edges.size downTo 0).first { okay(it + 1) }

}
