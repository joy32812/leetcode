package com.leetcode

fun longestAwesome(s: String): Int {

    var ans = 1
    val posMap = mutableMapOf<Int, Int>()
    posMap[0] = -1
    val digits = Array(10) { 0 }
    for (i in s.indices) {
        digits[s[i] - '0'] = 1 - digits[s[i] - '0']
        val value = digits.joinToString("").toInt(2)


        for (j in digits.indices) {
            val list = digits.toMutableList()
            list[j] = 1 - list[j]
            val v2 = list.joinToString("").toInt(2)
            if (v2 in posMap) ans = Math.max(ans, i - posMap[v2]!!)
        }


        if (value in posMap) ans = Math.max(ans, i - posMap[value]!!)
        else posMap[value] = i
    }

    return ans
}
