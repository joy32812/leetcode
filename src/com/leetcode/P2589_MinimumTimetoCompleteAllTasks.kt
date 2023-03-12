/**
 * Greedy.
 * Sort ranges by end time and pick the end time first.
 */
fun findMinimumTime(tasks: Array<IntArray>): Int {

    tasks.sortWith(compareBy({ it[1] }, { it[0] }))

    val lines = mutableSetOf<Int>()

    for (i in tasks.indices) {
        val (l, r, d) = tasks[i]

        val already = (l..r).count { it in lines }
        if (already >= d) continue

        (r downTo l).filter { it !in lines }.take(d - already).forEach { lines.add(it) }
    }

    return lines.size
}
