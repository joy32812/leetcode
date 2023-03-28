/**
 * binary search.
 */
fun repairCars(ranks: IntArray, cars: Int): Long {

    var l = 0L
    var r = Long.MAX_VALUE / 2

    fun okay(m: Long): Boolean {
        var cnt = 0L

        for (rank in ranks) {

            cnt += Math.floor(Math.sqrt(m.toDouble() / rank)).toInt()

        }

        return cnt >= cars
    }

    while (l < r) {
        val mid = (l + r) / 2

        if (okay(mid)) {
            r = mid
        } else {
            l = mid + 1
        }
    }

    return l

}

