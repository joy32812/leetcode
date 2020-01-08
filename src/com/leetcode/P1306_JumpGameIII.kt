package com.leetcode

fun canReach(arr: IntArray, start: Int): Boolean {
    val colors = BooleanArray(arr.size) { false }

    fun mark(now: Int) {
        if (colors[now]) return;

        colors[now] = true

        if (now + arr[now] >= 0 && now + arr[now] < arr.size) mark(now + arr[now])
        if (now - arr[now] >= 0 && now - arr[now] < arr.size) mark(now - arr[now])
    }

    mark(start)

    return arr.toList().zip(colors.toList()).filter { it.first == 0 }.any { it.second }
}
