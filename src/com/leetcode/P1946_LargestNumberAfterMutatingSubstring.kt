package com.leetcode

/**
 * greedy
 */
fun maximumNumber(num: String, change: IntArray): String {

    val chars = num.toCharArray()
    for (i in chars.indices) {
        var d = chars[i] - '0'
        if (d >= change[d]) continue

        var j = i
        while (j < chars.size) {
            var dd = chars[j] - '0'
            if (dd > change[dd]) break
            chars[j] = '0' + change[dd]
            j ++
        }

        break
    }

    return chars.joinToString("")
}
