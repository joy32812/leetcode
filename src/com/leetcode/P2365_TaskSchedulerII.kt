/**
 * Greedy.
 */
fun taskSchedulerII(tasks: IntArray, space: Int): Long {
    val lastMap = mutableMapOf<Int, Long>()

    var ans = 0L

    for (i in tasks.indices) {
        val t = tasks[i]

        if (t !in lastMap) {
            ans ++
        } else {
            val last = lastMap[t]!!
            if (ans + 1 - last > space) {
                ans ++
            } else {
                ans = last + space + 1
            }
        }

        lastMap[t] = ans
    }

    return ans
}
