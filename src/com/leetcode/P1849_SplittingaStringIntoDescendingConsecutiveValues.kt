package com.leetcode

import java.math.BigInteger

/**
 * dfs
 */
fun splitString(s: String): Boolean {
    if (s.length == 1) return false

    fun dfs(i: Int, should: BigInteger): Boolean {
        if (i >= s.length) return true

        return (i until s.length).any {
            s.substring(i..it).toBigInteger() == should && dfs(
                it + 1, should.subtract(
                    BigInteger.ONE
                )
            )
        }
    }

    return (0 until s.length - 1).any { dfs(it + 1, s.substring(0..it).toBigInteger().subtract(BigInteger.ONE)) }
}

fun main() {
    println(ULong.MAX_VALUE)
    println(splitString("10"))
}
