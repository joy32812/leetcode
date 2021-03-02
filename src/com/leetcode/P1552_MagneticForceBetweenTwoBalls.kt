package com.leetcode

fun maxDistance(position: IntArray, m: Int): Int {
    position.sort()

    var l = 1
    var r = position.last() + 1

    fun canotPutAll(x: Int): Boolean {
        var lastPos = position[0]
        var cnt = 1

        for (i in 1 until position.size) {
            if (position[i] - lastPos >= x) {
                cnt ++
                lastPos = position[i]
            }

            if (cnt >= m) return false
        }
        return true
    }

    while (l < r) {
        val m = (l + r) / 2
        if (canotPutAll(m)) r = m
        else l = m + 1
    }

    return l - 1
}
