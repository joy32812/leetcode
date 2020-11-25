package com.leetcode

/**
 * greedy algorithm
 */
fun minimumEffort(tasks: Array<IntArray>): Int {
    var sum = tasks.sumBy { it[0] }
    var ans = sum
    tasks.sortByDescending { it[1] - it[0] }

    for (task in tasks) {
        if (sum < task[1]) {
            ans += task[1] - sum
            sum = task[1]
        }

        sum -= task[0]
    }

    return ans
}

fun main() {
    println("Hello")
}
