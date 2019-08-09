package com.leetcode


fun shortestWay(source: String, target: String): Int {
    if (target.toSet().any { it !in source }) return -1

    var ans = 0
    var pos = source.length

    for (ch in target) {
        while (true) {
            if (pos == source.length) {
                ans ++
                pos = 0
            }

            if (source[pos++] == ch) break
        }
    }
    return ans

}