package com.leetcode

/**
 * greedy
 */
fun stoneGameIX(stones: IntArray): Boolean {

    val gp = stones.map { it % 3 }.groupBy { it }.mapValues { it.value.size }

    fun check(k: Int): Boolean {
        val cnt = Array(3) { 0 }
        (0 until 3).forEach { cnt[it] = gp[it] ?: 0 }

        if (cnt[k] == 0) return false
        cnt[k] --
        var sum = k

        for (i in 1 until stones.size) {

            if (cnt[1] > 0 && (sum + 1) % 3 != 0) {
                cnt[1] --
                sum += 1
            } else if (cnt[2] > 0 && (sum + 2) % 3 != 0) {
                cnt[2] --
                sum += 2
            } else if(cnt[0] > 0 && sum % 3 != 0) {
                cnt[0] --
            } else {
                return i % 2 != 0
            }
        }

        return false
    }

    return check(1) || check(2)
}
