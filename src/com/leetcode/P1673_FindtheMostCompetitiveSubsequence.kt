package com.leetcode

import java.util.*

fun mostCompetitive(nums: IntArray, k: Int): IntArray {

    val stack = Stack<Int>();
    for (i in nums.indices) {
        val d = nums[i]
        while (stack.isNotEmpty() && stack.peek() > d && stack.size - 1 + nums.size - i >= k) {
            stack.pop()
        }
        stack.push(d)
    }

    return stack.toList().subList(0, k).toIntArray()

}

fun main() {
    println("Hello, World!")
}
