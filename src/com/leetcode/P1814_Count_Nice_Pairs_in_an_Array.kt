package com.leetcode

/**
 * A + rev(B) = B + rev(A)
 * A - rev(A) = B - rev(B)
 * count the num of X - rev(X)
 */
fun countNicePairs(nums: IntArray): Int {

    val mapValues = nums.map { it - ("" + it).reversed().toInt() }.groupBy { it }.mapValues { it.value.size }

    var ans = 0L
    val MOD = 1_000_000_000 + 7
    for (d in mapValues.values) {
        ans = (ans + 1L * d * (d - 1) / 2) % MOD
    }

    return ans.toInt()
}


fun main() {

}
