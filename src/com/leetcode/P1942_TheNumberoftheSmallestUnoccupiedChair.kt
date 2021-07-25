package com.leetcode

import java.util.*

/**
 * TreeMap or PriorityQueue
 * compareBy to sort by multiple fields
 */
fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
    val n = times.size
    val treeSet = TreeSet<Int>()
    (0..n).forEach { treeSet.add(it) }

    class Event(val id: Int, val time: Int, val flag: Int)
    val events = mutableListOf<Event>()

    for (i in times.indices) {
        val (s, e) = times[i]
        events.add(Event(i, s, 1))
        events.add(Event(i, e, 0))
    }

    events.sortWith(compareBy({ it.time }, {it.flag}))
    val sitMap = mutableMapOf<Int, Int>()

    for (event in events) {
        val id = event.id
        val flag = event.flag

        if (flag == 0) {
            treeSet.add(sitMap[id]!!)
            sitMap.remove(id)
        } else {
            val seat = treeSet.first()!!
            sitMap[id] = seat
            treeSet.remove(seat)

            if (id == targetFriend) return seat
        }
    }

    return 0
}
