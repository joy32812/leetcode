package com.leetcode

/**
 * check every possible factor.
 * for each x:
 * get y = gcd(all the nums[k]) if nums[k] % x == 1
 *
 * if (x == y) then x will be a gcd
 */
fun countDifferentSubsequenceGCDs(nums: IntArray): Int {
    val N = 2 * 1_000_00 + 10
    val fact = Array(N) { 0 }

    fun gcd(a: Int, b: Int): Int = if (a % b == 0) b else gcd(b, a % b)

    for (d in nums) {
        for (x in 1..d) {
            if (x * x > d) break
            if (d % x != 0) continue

            val y = d / x
            fact[x] = if (fact[x] == 0) d else gcd(fact[x], d)
            fact[y] = if (fact[y] == 0) d else gcd(fact[y], d)
        }
    }

    return (1 until N).count { fact[it] == it }
}

fun main() {
//    println(countDifferentSubsequenceGCDs(intArrayOf(6, 10, 3)))
    println(countDifferentSubsequenceGCDs(intArrayOf(5, 5, 6, 15, 40)))
}
