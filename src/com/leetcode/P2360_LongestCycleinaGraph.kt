/**
 * traversal.
 */
fun longestCycle(edges: IntArray): Int {
    val n = edges.size

    var ans = -1
    val set = HashSet<Int>()
    fun dij(x: Int) {
        val dis = mutableMapOf<Int, Int>()
        dis[x] = 0
        set += x

        var u = x
        while (edges[u] != -1) {
            val v = edges[u]

            if (v in dis) ans = maxOf(ans, dis[u]!! + 1 - dis[v]!!)
            dis[v] = dis[u]!! + 1

            if (v in set) break
            set += v

            u = v
        }
    }

    for (i in 0 until n) {
        if (i !in set) dij(i)
    }

    return ans
}

fun main() {
    println(longestCycle(intArrayOf(3, 3, 4, 2, 3)))
}
