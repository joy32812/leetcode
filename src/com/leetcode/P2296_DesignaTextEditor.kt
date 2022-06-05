package com.leetcode

import java.lang.StringBuilder
import java.util.*

/**
 * Two stacks to imitate the cursor.
 */
class TextEditor() {

    val left = Stack<Char>()
    val right = Stack<Char>()

    fun addText(text: String) {
        text.forEach { left.push(it) }
    }

    fun deleteText(k: Int): Int {
        var cnt = 0
        repeat(k) {
            if (left.isEmpty()) return cnt
            cnt ++
            left.pop()
        }
        return cnt
    }

    private fun getStr(): String {
        val sb = StringBuilder()
        for (i in 0 until 10) {
            if (left.isEmpty()) break
            sb.append(left.pop())
        }

        val ans = sb.toString().reversed()

        for (c in ans) left.push(c)

        return ans
    }

    fun cursorLeft(k: Int): String {
        for (i in 0 until k) {
            if (left.isEmpty()) break
            right.push(left.pop())
        }

        return getStr()
    }

    fun cursorRight(k: Int): String {
        for (i in 0 until k) {
            if (right.isEmpty()) break
            left.push(right.pop())
        }

        return getStr()
    }

}
