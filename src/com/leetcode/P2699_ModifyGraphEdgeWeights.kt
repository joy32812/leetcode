    import java.util.LinkedList

    fun modifiedGraphEdges(n: Int, edges: Array<IntArray>, source: Int, destination: Int, target: Int): Array<IntArray> {
        val dist = IntArray(n) { Int.MAX_VALUE }
        dist[source] = 0

        val (normalEdges, specialEdges) = edges.partition { it[2] != -1 }

        fun getEdgeMap(es: List<IntArray>): MutableMap<Int, MutableList<Pair<Int, Int>>> {
            val edgeMap = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
            for ((u, v, w) in es) {
                edgeMap.getOrPut(u) { mutableListOf() }.add(v to w)
                edgeMap.getOrPut(v) { mutableListOf() }.add(u to w)
            }
            return edgeMap
        }

        val edgeMap = getEdgeMap(normalEdges)

        fun dijstra(froms: List<Int>) {

            val Q = LinkedList<Int>()
            val inQ = BooleanArray(n) { false }

            for (f in froms) {
                Q.add(f)
                inQ[f] = true
            }

            while (Q.isNotEmpty()) {
                val u = Q.poll()
                inQ[u] = false

                if (dist[u] == Int.MAX_VALUE) continue

                val neighbors = edgeMap[u] ?: continue
                for ((v, w) in neighbors) {
                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w
                        if (!inQ[v]) {
                            Q.add(v)
                            inQ[v] = true
                        }
                    }
                }
            }
        }

        dijstra(listOf(source))
        if (dist[destination] < target) return emptyArray()
        if (dist[destination] == target) return (normalEdges + specialEdges.map { intArrayOf(it[0], it[1], 2 * 1000_000_000) }).toTypedArray()

        fun addOneEdge(u: Int, v: Int) {
            edgeMap.getOrPut(u) { mutableListOf() }.add(v to 1)
            edgeMap.getOrPut(v) { mutableListOf() }.add(u to 1)

            dijstra(listOf(u, v))
        }


        val finalEdges = mutableListOf<IntArray>()

        for (i in specialEdges.indices) {
            val (u, v, _) = specialEdges[i]

            addOneEdge(u, v)

            if (dist[destination] <= target) {
                finalEdges += intArrayOf(u, v, target - dist[destination] + 1)

                for (j in i + 1 until specialEdges.size) {
                    finalEdges += intArrayOf(
                        specialEdges[j][0],
                        specialEdges[j][1],
                        2 * 1000_000_000
                    )
                }

                return (normalEdges + finalEdges).toTypedArray()
            } else {
                finalEdges += intArrayOf(u, v, 1)
            }
        }

        return emptyArray()
    }

    fun main() {
        // 4
        //[[0,1,-1],[2,0,2],[3,2,6],[2,1,10],[3,0,-1]]
        //1
        //3
        //12
        println(
            modifiedGraphEdges(
                4,
                arrayOf(
                    intArrayOf(0, 1, -1),
                    intArrayOf(2, 0, 2),
                    intArrayOf(3, 2, 6),
                    intArrayOf(2, 1, 10),
                    intArrayOf(3, 0, -1)
                ),
                1,
                3,
                12
            ).contentDeepToString()
        )

    }
