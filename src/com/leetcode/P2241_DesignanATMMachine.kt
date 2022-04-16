package com.leetcode

/**
 * brute force
 */
class ATM() {

    val vs = intArrayOf(20, 50, 100, 200, 500)
    val nums = Array(5) { 0L }

    fun deposit(banknotesCount: IntArray) {
        for (i in banknotesCount.indices) nums[i] += banknotesCount[i].toLong()
    }

    fun withdraw(amount: Int): IntArray {
        val tmp = Array(5) { 0L }
        var total = amount.toLong()

        for (i in nums.indices.reversed()) {
            val z = Math.min(total / vs[i], nums[i])
            tmp[i] = z

            total -= z * vs[i]
        }

        if (total != 0L) return intArrayOf(-1)

        for (i in tmp.indices) nums[i] -= tmp[i]
        return tmp.map { it.toInt() }.toIntArray()
    }
}

