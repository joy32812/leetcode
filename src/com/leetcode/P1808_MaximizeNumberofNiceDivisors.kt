package com.leetcode

/**
 * https://www.geeksforgeeks.org/breaking-integer-to-get-maximum-product/
 */
fun maxNiceDivisors(primeFactors: Int): Int {
    val MOD = 1_000_000_000 + 7
    var total = primeFactors

    var num = total / 3
    var last = 1
    if (total % 3 == 1 && num > 0) {
        num --
        last += 3
    }

    fun prod(x: Int): Long {
        if (x == 0) return 1
        var result = prod(x / 2)
        result = result * result % MOD
        if (x % 2 == 1) result = result * 3 % MOD

        return result
    }


    return (prod(num) * last % MOD).toInt()
}

fun main() {
    println(maxNiceDivisors(18))
}
