/**
 * Get distances for both nodes.
 */
fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    val n = edges.size
    fun dij(x: Int): IntArray {
        val dis = IntArray(n) { Int.MAX_VALUE }
        dis[x] = 0

        var u = x
        while (edges[u] != -1) {
            val v = edges[u]

            if (dis[v] > dis[u] + 1) {
                dis[v] = dis[u] + 1
            } else break
            u = v
        }

        return dis
    }

    val dis1 = dij(node1)
    val dis2 = dij(node2)

    var sum = Int.MAX_VALUE
    var ans = -1

    for (i in 0 until n) {
        if (dis1[i] == Int.MAX_VALUE || dis2[i] == Int.MAX_VALUE) continue
        if (sum > maxOf(dis1[i], dis2[i])) {
            sum = maxOf(dis1[i], dis2[i])
            ans = i
        }
    }

    return ans
}
