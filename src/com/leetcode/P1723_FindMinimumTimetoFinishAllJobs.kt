package com.leetcode

/**
 * binary search + dfs
 */
fun minimumTimeRequired(jobs: IntArray, k: Int): Int {


    var bucket = Array(k) { 0 }
    var ifOkay = false


    fun dfs(i: Int, limit: Int) {
        if (i == jobs.size) {
            ifOkay = true
            return
        }

        for (j in bucket.indices) {
            if (bucket[j] + jobs[i] <= limit) {
                bucket[j] += jobs[i]

                dfs(i + 1, limit)
                if (ifOkay) return

                bucket[j] -= jobs[i]

                if (bucket[j] == 0) break
            }
        }
    }

    fun okay(x: Int): Boolean {
        ifOkay = false
        bucket = Array(k) { 0 }

        dfs(0, x)
        return ifOkay
    }

    jobs.sortDescending()
    val sum = jobs.sum()
    var r = sum
    var l = Math.max(sum / k, jobs.max()!!)
    while (l < r) {
        val m = (l + r) / 2
        if (okay(m)) r = m
        else l = m + 1
    }

    return l
}


fun main() {
    println(
            minimumTimeRequired(
                    intArrayOf(1, 2, 4, 7, 8),
                    2
            )
    )
}
