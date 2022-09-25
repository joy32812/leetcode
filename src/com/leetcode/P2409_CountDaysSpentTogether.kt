/**
 * brute force.
 */
fun countDaysTogether(arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String): Int {

    val days = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    fun okay(m: Int, d: Int, from: String, to: String): Boolean {

        val month = if (m < 10) "0$m" else "$m"
        val day = if (d < 10) "0$d" else "$d"

        val date = "$month-$day"

        return date in from..to
    }

    var cnt = 0
    for (i in 1..12) {
        for (j in 1 .. days[i - 1]) {
            if (okay(i, j, arriveAlice, leaveAlice) && okay(i, j, arriveBob, leaveBob)) {
                cnt++
            }
        }
    }

    return cnt

}
