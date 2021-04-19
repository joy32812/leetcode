package com.leetcode

import java.util.*

fun getOrder(tasks: Array<IntArray>): IntArray {
    class Task(val index: Int, val enqueueTime: Int, val processTime: Int)

    val sortedTasks = tasks.mapIndexed { index, ints -> Task(index, ints[0], ints[1]) }
        .sortedWith(compareBy({ it.enqueueTime }, { it.processTime }))

    val pq = PriorityQueue<Task> { t1, t2 ->
        when {
            t1.processTime != t2.processTime -> t1.processTime - t2.processTime
            else -> t1.index - t2.index
        }
    }

    var currentTime = 0

    val ans = mutableListOf<Int>()
    var i = 0
    while (true) {
        if (pq.isEmpty()) {
            currentTime = sortedTasks[i].enqueueTime
            pq.add(sortedTasks[i])
            i++
        }

        val curTask = pq.poll()
        ans += curTask.index
        currentTime += curTask.processTime

        while (i < sortedTasks.size && currentTime >= sortedTasks[i].enqueueTime) {
            pq.add(sortedTasks[i])
            i++
        }

        if (i == tasks.size && pq.isEmpty()) break
    }

    return ans.toIntArray()
}

fun main() {

    println(
        getOrder(
            arrayOf(
                intArrayOf(19, 13),
                intArrayOf(16, 9),
                intArrayOf(21, 10),
                intArrayOf(32, 25),
                intArrayOf(37, 4),
                intArrayOf(49, 24),
                intArrayOf(2, 15),
                intArrayOf(38, 41),
                intArrayOf(37, 34),
                intArrayOf(33, 6),
                intArrayOf(45, 4),
                intArrayOf(18, 18),
                intArrayOf(46, 39),
                intArrayOf(12, 24)
            )
        )
    )

}
