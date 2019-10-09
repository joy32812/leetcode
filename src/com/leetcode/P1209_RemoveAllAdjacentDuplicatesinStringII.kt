package com.leetcode

import java.lang.StringBuilder
import java.util.*


fun removeDuplicates(s: String, k: Int): String {

    val stack = Stack<Pair<Char, Int>>()

    for (ch in s) {
        if (stack.isEmpty() || stack.peek().first != ch) {
            stack.push(Pair(ch, 1))
        } else {
            val now = stack.pop()
            if (now.second + 1 < k) {
                stack.push(Pair(ch, now.second + 1))
            }
        }
    }

    val sb = StringBuilder()
    while (!stack.isEmpty()) {
        val now = stack.pop()
        for (i in 1..now.second) sb.append(now.first)
    }

    return sb.reverse().toString()
}

fun main() {
    println("Hello")
}
