package com.leetcode

fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {

    quantity.sortDescending()
    val gp = nums.groupBy { it }.mapValues { it.value.size }.filterValues { it >= quantity.last() }.toMutableMap()


    fun dfs(group: MutableMap<Int, Int>, pos: Int): Boolean {
        if (pos == quantity.size) return true
        if (group.values.sum() < quantity.filterIndexed { index, i -> index >= pos }.sum()) return false

        for ((data, num) in gp) {
            if (num == quantity[pos]) {
                val tmp = gp[data]!!
                gp[data] = 0
                val result = dfs(gp, pos + 1)
                gp[data] = tmp
                return result
            }
        }
        for ((data, num) in gp) {
            if (num < quantity[pos]) continue

            val tmp = gp[data]!!
            val left = gp[data]!! - quantity[pos]
            gp[data] = if (left < quantity.last()) 0 else left
            if (dfs(gp, pos + 1)) return true
            gp[data] = tmp
        }

        return false
    }

    return dfs(gp, 0)
}

fun main() {

    println(canDistribute(
        intArrayOf(1, 1, 2, 2, 1),
        intArrayOf(2, 3)
    ))

}
