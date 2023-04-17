import java.util.LinkedList

class Graph(n: Int, edges: Array<IntArray>) {
    val N = n

    val dist = Array(N) { IntArray(N) { Int.MAX_VALUE } }

    init {

        // floyd-warshall
        for (i in 0 until N) {
            dist[i][i] = 0
        }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]
            dist[u][v] = w
        }

        for (k in 0 until N) {
            for (i in 0 until N) {
                for (j in 0 until N) {
                    if (dist[i][k] != Int.MAX_VALUE && dist[k][j] != Int.MAX_VALUE) {
                        dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
                    }
                }
            }
        }
    }

    fun addEdge(edge: IntArray) {
        val Q = LinkedList<IntArray>().apply { add(edge) }

        while (Q.isNotEmpty()) {
            val (u, v, w) = Q.removeFirst()

            if (dist[u][v] <= w) continue
            dist[u][v] = w

            // update from u
            for (t in 0 until N) {
                if (dist[v][t] != Int.MAX_VALUE && dist[u][v] + dist[v][t] < dist[u][t]) {
                    Q.add(intArrayOf(u, t, dist[u][v] + dist[v][t]))
                }
            }

            // update from others
            for (t in 0 until N) {
                if (dist[t][u] != Int.MAX_VALUE && dist[t][u] + dist[u][v] < dist[t][v]) {
                    Q.add(intArrayOf(t, v, dist[t][u] + dist[u][v]))
                }
            }
        }
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        if (dist[node1][node2] == Int.MAX_VALUE) return -1
        return dist[node1][node2]
    }

}

fun main() {
    // ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
    //[[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]

    val graph = Graph(4, arrayOf(intArrayOf(0, 2, 5), intArrayOf(0, 1, 2), intArrayOf(1, 2, 1), intArrayOf(3, 0, 3)))
    println(graph.shortestPath(3, 2))
    println(graph.shortestPath(0, 3))
    graph.addEdge(intArrayOf(1, 3, 4))
    println(graph.shortestPath(0, 3))

}
