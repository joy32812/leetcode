import java.util.LinkedList

private data class Point(val x: Int, val y: Int)

fun minimumCost(start: IntArray, target: IntArray, specialRoads: Array<IntArray>): Int {

    val S = Point(start[0], start[1])
    val T = Point(target[0], target[1])

    fun distance(p1: Point, p2: Point) = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y)

    val edges = mutableMapOf<Point, MutableList<Pair<Point, Int>>>()
    val points = mutableSetOf(S, T)

    for ((x1, y1, x2, y2, d) in specialRoads) {
        val p1 = Point(x1, y1)
        val p2 = Point(x2, y2)

        points.add(p1)
        points.add(p2)

        edges.getOrPut(p1) { mutableListOf() }.add(Pair(p2, d))
//        edges.getOrPut(p2) { mutableListOf() }.add(Pair(p1, d))
    }


    for (p1 in points) {
        for (p2 in points) {
            if (p1 == p2) continue
            edges.getOrPut(p1) { mutableListOf() }.add(Pair(p2, distance(p1, p2)))
        }
    }

    val dist = mutableMapOf<Point, Int>()
    dist[S] = 0
    val Q = LinkedList<Point>().apply { add(S) }
    val inQ = mutableSetOf(S)

    while (Q.isNotEmpty()) {
        val p = Q.poll()
        inQ.remove(p)

        val neibors = edges[p] ?: continue

        for ((q, d) in neibors) {
            if (dist[q] == null || dist[q]!! > dist[p]!! + d) {
                dist[q] = dist[p]!! + d
                if (q !in inQ) {
                    Q.add(q)
                    inQ.add(q)
                }
            }
        }

    }

    return dist[T]!!
}

