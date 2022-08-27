/**
 * easy
 */
fun edgeScore(edges: IntArray): Int {
    val scores = Array(edges.size) { 0L }

    for (u in edges.indices) {
        val v = edges[u]
        scores[v] = scores[v] + u
    }

    val max = scores.maxOrNull() ?: 0
    return scores.indexOfFirst { it == max }
}
