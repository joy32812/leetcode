/**
 * meger and power of 2
 */
fun countWays(ranges: Array<IntArray>): Int {

    fun mergeRanges(ranges: Array<IntArray>): Array<IntArray> {
        val sorted = ranges.sortedBy { it[0] }
        val ans = mutableListOf<IntArray>()
        var l = sorted[0][0]
        var r = sorted[0][1]
        for (i in 1 until sorted.size) {
            if (sorted[i][0] <= r) {
                r = maxOf(r, sorted[i][1])
            } else {
                ans.add(intArrayOf(l, r))
                l = sorted[i][0]
                r = sorted[i][1]
            }
        }
        ans.add(intArrayOf(l, r))
        return ans.toTypedArray()
    }

    val merged = mergeRanges(ranges)

    val mod = 1000000007L
    var ans = 1L

    for (i in 0 until merged.size) {
        ans = (ans * 2) % mod
    }

    return ans.toInt()
}
