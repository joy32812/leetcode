package com.leetcode

import java.util.*

fun reverseParentheses(s: String): String {
    if (s === "") return ""

    val pair = IntArray(s.length) {0}
    val stack = Stack<Int>()
    for (i in s.indices) {
        if (s[i] == '(') {
            stack.push(i)
        } else if (s[i] == ')') {
            val j = stack.pop()
            pair[j] = i
            pair[i] = j
        }
    }

    var ans = StringBuilder()

    var i = 0
    var d = 1
    while (i < s.length) {
        if (s[i] == '(' || s[i] == ')') {
            i = pair[i]
            d = -d
        } else {
            ans.append(s[i])
        }

        i += d
    }

    return ans.toString()
}


fun main() {

    println(reverseParentheses("(u(love)i)"))

    println(reverseParentheses("sxmdll(q)eki(x)"))
}
