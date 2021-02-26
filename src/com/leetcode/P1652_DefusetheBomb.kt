package com.leetcode

fun decrypt(code: IntArray, k: Int): IntArray {
    val n = code.size
    if (k == 0) return Array(n) { 0 }.toIntArray()

    return code.mapIndexed { i, _ ->
        val dx = if (k > 0) 1 else -1
        val num = Math.abs(k)
        var cur = i
        var cnt = 0
        var sum = 0
        while (cnt < num) {
            cur = (cur + n + dx) % n
            sum += code[cur]
            cnt++
        }
        sum
    }.toIntArray()
}
