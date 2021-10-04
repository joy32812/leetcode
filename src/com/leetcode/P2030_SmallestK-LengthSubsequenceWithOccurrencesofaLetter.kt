package com.leetcode

import java.util.*

/**
 * stack
 */
fun smallestSubsequence(s: String, k: Int, letter: Char, repetition: Int): String {

    val n = s.length
    val suf = Array(n) { 0 }
    for (i in s.indices.reversed()) {
        suf[i] = (if (i + 1 < n) suf[i + 1] else 0) + (if (s[i] == letter) 1 else 0)
    }

    var curNum = 0
    val stack = Stack<Char>()
    fun canRemoveTop(i: Int): Boolean {
        if (stack.peek() <= s[i]) return false
        val now = if (stack.peek() == letter) curNum - 1 else curNum
        if (now + suf[i] < repetition) return false
        return stack.size - 1 + n - i >= k
    }

    fun canAdd(i: Int) = s[i] == letter || k - stack.size - 1 + curNum >= repetition
    fun push(c: Char) {
        stack.push(c)
        if (c == letter) curNum ++
    }
    fun pop(c: Char) {
        stack.pop()
        if (c == letter) curNum --
    }

    for (i in s.indices) {
        while (stack.isNotEmpty() && canRemoveTop(i)) pop(stack.peek())
        if (canAdd(i)) push(s[i])
    }

    return stack.joinToString("").substring(0, k)
}

fun main() {
    println(smallestSubsequence(
        "aaabbbcccddd",
        3,
        'b',
        2
    ))
}
