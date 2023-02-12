/**
 * Notice the max value of x is 2^33, so we can precompute all possible xor values.
 */
fun substringXorQueries(s: String, queries: Array<IntArray>): Array<IntArray> {
    val MAX = 1L shl 33
    val posMap = mutableMapOf<Long, Int>()

    for (i in s.indices) {
        if (s[i] == '0') {
            if (0L !in posMap) posMap[0L] = i
            continue
        }
        var x = 0L
        for (j in i until s.length) {
            x = x * 2 + (s[j] - '0')
            if (x >= MAX) break
            if (x !in posMap) posMap[x] = i
        }
    }


    return queries.map {
        val x = (it[0] xor it[1])
        val p = posMap[x.toLong()] ?: -1

        if (p == -1) {
            intArrayOf(-1, -1)
        } else {
            intArrayOf(p, p + x.toString(2).length - 1)
        }
    }.toTypedArray()

}
