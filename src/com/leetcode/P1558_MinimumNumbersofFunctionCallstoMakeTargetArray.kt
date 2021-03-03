package com.leetcode

fun minOperations(nums: IntArray): Int {

    fun getOpNums(n: Int): Pair<Int, Int> {
        var now = n
        var op1 = 0
        var op2 = 0
        while (now > 0) {
            op1 += now % 2
            if (now >= 2) op2 ++
            now /= 2
        }
        return Pair(op1, op2)
    }

    val ops = nums.map { getOpNums(it) }
    return ops.sumBy { it.first } + ops.maxBy { it.second }!!.second
}

fun main() {
    println(minOperations(intArrayOf(1, 5)))
}
