package com.leetcode

fun minInsertions(s: String): Int {
    var leftCnt = 0
    var i = 0
    var ans = 0
    while (i < s.length) {
        if (s[i] == '(') {
            leftCnt ++
            i ++
        } else {
            if (i + 1 < s.length && s[i + 1] == ')') {
                if (leftCnt > 0) leftCnt --
                else ans ++
                i += 2
            } else {
                if (leftCnt > 0) leftCnt --
                else ans ++
                ans ++
                i ++
            }
        }
    }

    return ans + 2 * leftCnt
}

fun main() {
    println(minInsertions("(()))(()))()())))"))
}
