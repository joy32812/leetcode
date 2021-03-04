package com.leetcode

import java.util.*

fun makeGood(s: String): String {

    val stack = LinkedList<Char>()
    fun isBad(x: Char, y: Char) = x != y && x.equals(y, ignoreCase = true)

    for (ch in s) {
        if (stack.isNotEmpty() && isBad(stack.peek(), ch)) {
            stack.pop()
        } else {
            stack.push(ch)
        }
    }

    return stack.joinToString("").reversed()
}

fun main() {
    println(makeGood("leEeetcode"))
}
