package com.leetcode


/**
 * DP
 */
fun minFlips2(s: String): Int {
    val n = s.length
    if (n == 1) return 0

    val front = Array(n) { Array(2) { 0 } }
    val back = Array(n) { Array(2) { 0 } }

    for (i in s.indices) {
        front[i][0] = (if (i - 1 >= 0) front[i - 1][0] else 0) + (if (i % 2 == s[i] - '0') 0 else 1)
        front[i][1] = (if (i - 1 >= 0) front[i - 1][1] else 0) + (if (i % 2 != s[i] - '0') 0 else 1)
    }

    for (i in s.indices.reversed()) {
        back[i][0] = (if (i + 1 < n) back[i + 1][0] else 0) + (if ((n - 1 - i) % 2 == s[i] - '0') 0 else 1)
        back[i][1] = (if (i + 1 < n) back[i + 1][1] else 0) + (if ((n - 1 - i) % 2 != s[i] - '0') 0 else 1)
    }

    var ans = Int.MAX_VALUE

    for (i in 0 until n - 1) {
        val j = i + 1
        ans = Math.min(ans, front[i][0] + back[j][1])
        ans = Math.min(ans, front[i][1] + back[j][0])

        if (n % 2 == 1) {
            ans = Math.min(ans, front[i][0] + back[j][0])
            ans = Math.min(ans, front[i][1] + back[j][1])
        }
    }

    return ans
}

fun main() {
    println(minFlips2("111000"))
}
