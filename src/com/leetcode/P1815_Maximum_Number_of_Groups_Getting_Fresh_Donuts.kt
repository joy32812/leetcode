package com.leetcode

/**
 * dfs with memo
 */
fun maxHappyGroups(batchSize: Int, groups: IntArray): Int {
    val gp = groups.map { it % batchSize }.groupBy { it }.mapValues { it.value.size }
    var ans = gp[0] ?: 0
    val sizes = (0 until batchSize).map { gp[it] ?: 0 }.toMutableList()
    sizes[0] = 0

    var resMap = mutableMapOf<String, Int>()
    fun dfs(arr: MutableList<Int>): Int {
        val key = arr.joinToString(",")
        if (key in resMap) return resMap[key]!!

        val sum = arr[0]
        var res = 0
        for (i in 1 until arr.size) {
            if (arr[i] == 0) continue

            val happy = if (sum == 0) 1 else 0
            val newSum = sum + i

            arr[i] --
            arr[0] = newSum % batchSize
            res = Math.max(res, happy + dfs(arr))
            arr[0] = sum
            arr[i] ++
        }

        resMap[key] = res
        return res
    }

    return ans + dfs(sizes)
}

fun main() {
    println(maxHappyGroups(4, intArrayOf(1, 3, 2, 5, 2, 2, 1, 6)))
}
