fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
    logs.sortBy { it[1] }

    val ansMap = mutableMapOf<Int, Int>()
    val sortedQuery = queries.sorted()

    var l = 0
    var r = 0

    val serverMap = mutableMapOf<Int, Int>()

    for (q in sortedQuery) {

        while (r < logs.size && logs[r][1] <= q) {
            val server = logs[r][0]
            serverMap[server] = serverMap.getOrDefault(server, 0) + 1
            r++
        }

        while (l < logs.size && logs[l][1] < q - x) {
            val server = logs[l][0]
            serverMap[server] = serverMap.getOrDefault(server, 0) - 1
            if (serverMap[server] == 0) serverMap.remove(server)
            l++
        }

        ansMap[q] = n - serverMap.keys.size
    }



    return queries.map { ansMap[it]!! }.toIntArray()
}
