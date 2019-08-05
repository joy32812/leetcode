package com.leetcode

import java.io.File.separator
import java.lang.StringBuilder


fun confusingNumber(N: Int): Boolean {

    val map = mapOf(
            0 to 0,
            1 to 1,
            6 to 9,
            8 to 8,
            9 to 6
    )

    for (c in ("" + N).reversed()) {
        if (!map.containsKey(c - '0')) return false
    }

    return (""+ N).reversed().map { map[it - '0'] }.joinToString(separator = "").toInt() != N

}