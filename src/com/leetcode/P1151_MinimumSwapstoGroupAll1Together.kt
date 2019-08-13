package com.leetcode


fun minSwaps(data: IntArray): Int {
    val oneNum = data.sum()
    var nowNum = data.withIndex().filter { it.index < oneNum }.sumBy { it.value }

    var ans = oneNum - nowNum
    for (i in oneNum until data.size) {
        if (data[i] == 1) nowNum ++
        if (data[i - oneNum] == 1) nowNum --
        ans = Math.min(ans, oneNum - nowNum)
    }

    return ans
}
