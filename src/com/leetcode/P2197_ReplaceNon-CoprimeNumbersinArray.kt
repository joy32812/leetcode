package com.leetcode

import java.util.*

/**
 * Stack
 */
fun replaceNonCoprimes(nums: IntArray): List<Int> {

    val stack = Stack<Int>()
    fun gcd(x: Int, y: Int) = x.toBigInteger().gcd(y.toBigInteger()).toInt()
    fun isCoPrime(x: Int, y: Int) = gcd(x, y) == 1
    fun getLCM(x: Int, y: Int) = (1L * x * y / gcd(x, y)).toInt()

    for (d in nums) {

        if (stack.isEmpty() || isCoPrime(d, stack.peek())) {
            stack.push(d)
            continue
        }

        var now = d
        while (stack.isNotEmpty() && !isCoPrime(now, stack.peek())) {
            val top = stack.pop()
            now = getLCM(now, top)
        }
        stack.push(now)
    }

    return stack.toList()
}

fun main() {
    println(replaceNonCoprimes(
        intArrayOf(13,121,143,143,11,11,11,143,143,93,31,31)
    ))
}
