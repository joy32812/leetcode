/**
 * Reverse compute.
 */
fun matrixSumQueries(n: Int, queries: Array<IntArray>): Long {

    val deletedRows = mutableSetOf<Int>()
    val deletedCols = mutableSetOf<Int>()

    var ans = 0L

    val queryReversed = queries.reversed()
    for ((type, id, v) in queryReversed) {

        if (type == 0) {
            if (id in deletedRows) continue
            ans += 1L * (n - deletedCols.size) * v

            deletedRows.add(id)
        } else {
            if (id in deletedCols) continue
            ans += 1L * (n - deletedRows.size) * v

            deletedCols.add(id)
        }
    }

    return ans
}
