/**
 * sweeping line.
 */
data class Point(val p: Int, val end: Int)
fun minGroups(intervals: Array<IntArray>): Int {

    val points = intervals.flatMap {
        listOf(
            Point(it[0], 1),
            Point(it[1] + 1, 0)
        )
    }.sortedWith(compareBy({ it.p }, { it.end }))


    var cnt = 0
    var max = 0

    for (pot in points) {

        if (pot.end == 1) {
            cnt++
        } else {
            cnt--
        }

        max = Math.max(max, cnt)
    }

    return max
}
