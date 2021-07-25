package com.leetcode

import java.util.*

/**
 * stack + binary search
 */
fun canSeePersonsCount(heights: IntArray): IntArray {

    val ans = mutableListOf<Int>()
    val stack = LinkedList<Int>()

    fun getAns(h: Int): Int {
        if (stack.isEmpty()) return 0
        if (stack.size == 1) return 1
        if (stack[0] > h) return 1
        if (stack.last() < h) return stack.size

        var l = 0
        var r = stack.size

        while (l < r) {
            val m = (l + r) / 2
            if (stack[m] > h) r = m
            else l = m + 1
        }

        return l + 1
    }

    for (i in heights.indices.reversed()) {
        ans += getAns(heights[i])

        while (stack.isNotEmpty() && heights[i] >= stack.peek()) stack.pop()
        stack.push(heights[i])
    }

    return ans.reversed().toIntArray()
}
