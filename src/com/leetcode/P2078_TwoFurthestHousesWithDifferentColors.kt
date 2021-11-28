package com.leetcode

fun maxDistance(colors: IntArray): Int {

    var ans = 0
    for (i in colors.indices) {
        for (j in i + 1 until colors.size) {
            if (colors[i] != colors[j]) ans = Math.max(ans, j - i)
        }
    }

    return ans
}
