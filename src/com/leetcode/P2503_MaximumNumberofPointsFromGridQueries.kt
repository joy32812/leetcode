/**
 * union-find.
 */
fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
    val ansMap = mutableMapOf<Int, Int>()
    val edgeMap = mutableMapOf<Int, MutableList<Int>>()

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    fun buildEdges() {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val id = i * grid[0].size + j

                for (k in dx.indices) {

                        val x = i + dx[k]
                        val y = j + dy[k]

                        if (x in grid.indices && y in grid[0].indices) {
                            val nid = x * grid[0].size + y
                            edgeMap.getOrPut(id) { mutableListOf() } += nid
                            edgeMap.getOrPut(nid) { mutableListOf() } += id
                        }
                }
            }
        }
    }
    buildEdges()

    val father = Array(grid.size * grid[0].size) { it }
    val total = Array(grid.size * grid[0].size) { 1 }

    fun getFather(x: Int): Int {
        if (father[x] == x) return x
        father[x] = getFather(father[x])
        return father[x]
    }

    val nodes = (0 until grid.size * grid[0].size).sortedBy { grid[it / grid[0].size][it % grid[0].size] }
    var i = 0

    fun work(query: Int) {

        while (i < nodes.size) {
            val id = nodes[i]
            val x = id / grid[0].size
            val y = id % grid[0].size

            if (grid[x][y] >= query) break

            val edges = edgeMap[id] ?: mutableListOf()

            for (e in edges) {
                val tx = e / grid[0].size
                val ty = e % grid[0].size
                if (grid[tx][ty] >= query) continue

                val fx = getFather(id)
                val fy = getFather(e)

                if (fx < fy) {
                    total[fx] += total[fy]
                    father[fy] = fx
                } else if (fx > fy) {
                    total[fy] += total[fx]
                    father[fx] = fy
                }
            }

            i ++
        }

        ansMap[query] = if (query > grid[0][0]) total[0] else 0
    }

    queries.toSortedSet().forEach { work(it) }

    return queries.map { ansMap[it]!! }.toIntArray()
}

fun main() {
    // grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
    println(maxPoints(arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 5, 7), intArrayOf(3, 5, 1)), intArrayOf(5, 6, 2)).toList())

    // grid = [[5,2,1],[1,1,2]], queries = [3]
    println(maxPoints(arrayOf(intArrayOf(5, 2, 1), intArrayOf(1, 1, 2)), intArrayOf(3)).toList())

}
