package com.leetcode

fun minOperations(target: IntArray, arr: IntArray): Int {
    val targetSet = target.toSet()
    val mapIndexed = target.mapIndexed { index, i -> i to index }.toMap()
    val nums = arr.filter { it in targetSet }.map { mapIndexed[it]!! }


    val stack = mutableListOf<Int>()
    for (d in nums) {
        if (stack.isEmpty()) stack += d
        else if (stack.last() < d) stack += d
        else {
            var l = 0
            var r = stack.size - 1
            while (l < r) {
                val m = (l + r) / 2
                if (stack[m] >= d) r = m
                else l = m + 1
            }
            stack[l] = d
        }
    }

    return target.size - stack.size
}
