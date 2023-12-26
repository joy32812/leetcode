import java.util.PriorityQueue

/**
 * Tree dp + priority queue
 */
fun placedCoins(edges: Array<IntArray>, cost: IntArray): LongArray {
    val n = cost.size

    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    for (edge in edges) {
        edgeMap.getOrPut(edge[0]) { mutableSetOf() }.add(edge[1])
        edgeMap.getOrPut(edge[1]) { mutableSetOf() }.add(edge[0])
    }

    val ans = LongArray(cost.size)
    fun dfs(id: Int, father: Int): Pair<PriorityQueue<Long>, PriorityQueue<Long>> {
        val pq1 = PriorityQueue<Long>().apply { add(cost[id].toLong()) }
        val pq2 = PriorityQueue<Long> { a, b -> b.compareTo(a) }.apply { add(cost[id].toLong()) }

        for (child in edgeMap[id]!!) {
            if (child == father) continue
            val childPq = dfs(child, id)
            pq1.addAll(childPq.first)
            pq2.addAll(childPq.second)
        }

        while (pq1.size > 3) pq1.poll()
        while (pq2.size > 3) pq2.poll()

        if (pq1.size < 3) {
            ans[id] = 1
        } else {
            val product1 = pq1.toList().reduce { acc, l -> acc * l }
            val zz = pq2.toList().sorted().take(2) + pq1.toList().sorted().takeLast(1)
            val product2 = zz.reduce { acc, l -> acc * l }
            val product = maxOf(product1, product2)

            ans[id] = if (product >= 0) product else 0
        }

        return pq1 to pq2
    }

    dfs(0, -1)


    return ans
}

fun main() {
    // [[0,2],[0,6],[1,4],[3,5],[7,6],[3,6],[1,8],[3,1],[9,3]]
    //[63,13,-6,20,56,-14,61,25,-99,54]
    println(placedCoins(arrayOf(intArrayOf(0, 2), intArrayOf(0, 6), intArrayOf(1, 4), intArrayOf(3, 5), intArrayOf(7, 6), intArrayOf(3, 6), intArrayOf(1, 8), intArrayOf(3, 1), intArrayOf(9, 3)), intArrayOf(63, 13, -6, 20, 56, -14, 61, 25, -99, 54)).toList())

    // Input: edges = [[0,1],[0,2],[0,3],[0,4],[0,5]], cost = [1,2,3,4,5,6]
    println(placedCoins(arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(0, 4), intArrayOf(0, 5)), intArrayOf(1, 2, 3, 4, 5, 6)).toList())
}
