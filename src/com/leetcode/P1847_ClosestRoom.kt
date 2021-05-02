package com.leetcode

import java.util.*

/**
 * sort query by size
 * And add those rooms with larger size to the treeSet
 * Then find the closest room id
 */
fun closestRoom(rooms: Array<IntArray>, queries: Array<IntArray>): IntArray {
    var i = 0
    rooms.sortByDescending { it[1] }

    val roomSet = TreeSet<Int>()
    class Query(val index: Int, val pId: Int, val mSize: Int)

    val queryList = queries.mapIndexed { index, ints -> Query(index, ints[0], ints[1]) }.sortedByDescending { it.mSize }

    val ans = Array(queries.size) { -1 }
    for (q in queryList) {
        val pId = q.pId
        val size = q.mSize
        while (i < rooms.size && rooms[i][1] >= size) {
            roomSet.add(rooms[i][0])
            i ++
        }

        if (roomSet.isEmpty()) continue

        val floor = roomSet.floor(pId)
        val ceiling = roomSet.ceiling(pId)

        if (floor == null) ans[q.index] = ceiling
        else if (ceiling == null) ans[q.index] = floor
        else ans[q.index] = if (Math.abs(pId - floor) <= Math.abs(pId - ceiling)) floor else ceiling
    }

    return ans.toIntArray()
}
