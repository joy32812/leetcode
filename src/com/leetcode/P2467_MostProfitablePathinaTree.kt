/**
 * 1. go up to the root from Bob. Find the timing when passing each node.
 * 2. go down from root.
 * 3. find max of the money of each leaf node.
 */
fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {

    val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
    val nodeSet = mutableSetOf<Int>()

    for ((u, v) in edges) {
        edgeMap.getOrPut(u) { mutableSetOf() } += v
        edgeMap.getOrPut(v) { mutableSetOf() } += u

        nodeSet += u
        nodeSet += v
    }


    val openTimes = Array(nodeSet.size) { Int.MAX_VALUE / 2 }
    val parents = Array(nodeSet.size) { -1 }

    fun dfs(node: Int, parent: Int) {
        parents[node] = parent
        for (child in edgeMap[node]!!) {
            if (child != parent) {
                dfs(child, node)
            }
        }
    }

    dfs(0, -1)


    var time = 0
    var cur = bob
    while (cur != -1) {
        openTimes[cur] = time
        time ++
        cur = parents[cur]
    }


    var ans = Int.MIN_VALUE
    fun work(node: Int, currentTime: Int, money: Int) {

        var curMoney = money
        if (currentTime < openTimes[node]) curMoney += amount[node]
        else if (currentTime == openTimes[node]) curMoney += amount[node] / 2

        val children = edgeMap[node]!!

        if (children.size == 1 && children.first() == parents[node]) {
            ans = maxOf(ans, curMoney)
            return
        }

        for (child in children) {
            if (child != parents[node]) {
                work(child, currentTime + 1, curMoney)
            }
        }
    }

    work(0, 0, 0)

    return ans
}

