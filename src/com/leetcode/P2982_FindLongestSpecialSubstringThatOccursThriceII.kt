fun maximumLength(s: String): Int {
    val alphaCnts = Array(26) { mutableListOf<Int>() }

    var last = '-'
    var cnt = 0

    for (c in s) {

        if (c == last) {
            cnt++
        } else {
            if (cnt > 0) {
                alphaCnts[last - 'a'].add(cnt)
            }
            last = c
            cnt = 1
        }

    }

    if (cnt > 0) {
        alphaCnts[last - 'a'].add(cnt)
    }

    fun maxLen(cnts: List<Int>): Int {
        if (cnts.isEmpty()) return -1

        val sorted = cnts.sortedDescending().take(3)
        if (sorted.sum() < 3) return -1

        var ans = sorted[0] - 2
        if (sorted.size >= 2 && sorted[1] + 1 >= sorted[0]) {
            ans = maxOf(ans, sorted[0] - 1)
        }
        if (sorted.size >= 3) {
            ans = maxOf(ans, sorted[2])
        }

        return ans
    }

    return alphaCnts.maxOf { maxLen(it) }
}
