package com.leetcode

import java.util.*


data class TheJob(val s: Int, val e: Int, val p: Int)
fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {

    val jobs = mutableListOf<TheJob>()
    for (i in startTime.indices) jobs += TheJob(startTime[i], endTime[i], profit[i])

    jobs.sortBy { it.e }
    val treeMap = TreeMap<Int, Int>()

    for (jb in jobs) {
        val floorEntry = treeMap.floorEntry(jb.s)
        var now = if (floorEntry == null) jb.p
        else floorEntry.value + jb.p

        val floorEntry1 = treeMap.floorEntry(jb.e)
        if (floorEntry1 != null) now = Math.max(now, floorEntry1.value)

        treeMap[jb.e] = now
    }


    return treeMap.values.max()!!

}

fun main() {

    println(jobScheduling(intArrayOf(1,2,3,3), intArrayOf(3,4,5,6), intArrayOf(50,10,40,70)))
    println(jobScheduling(intArrayOf(1,2,3,4,6), intArrayOf(3,5,10,6,9), intArrayOf(20,20,100,70,60)))
    println(jobScheduling(intArrayOf(1,1,1), intArrayOf(2,3,4), intArrayOf(5,6,4)))
    println(jobScheduling(intArrayOf(4, 2, 4, 8, 2), intArrayOf(5,5,5,10,8), intArrayOf(1,2,8,10,4)))

}
