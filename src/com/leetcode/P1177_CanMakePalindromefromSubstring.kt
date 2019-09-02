package com.leetcode


fun canMakePaliQueries(s: String, queries: Array<IntArray>): BooleanArray {

    val alphaNum = 26
    val cntArr = Array(s.length) {Array(26) {0} }
    for (i in s.indices) {
        val now = s[i] - 'a'
        for (j in 0 until alphaNum) {
            if (i != 0) cntArr[i][j] = cntArr[i - 1][j]
            if (j == now) cntArr[i][j] ++
        }
    }

    val ret = mutableListOf<Boolean>()
    for (index in queries.indices) {
        val (l, r, k) = queries[index]
        var total = 0
        for (j in 0 until alphaNum) {
            val left = if (l - 1 >= 0) cntArr[l - 1][j] else 0
            var right = cntArr[r][j]
            if ((right - left) % 2 == 1) total++
        }
        ret += total / 2 <= k
    }
    return ret.toBooleanArray()
}


fun main() {

    println(canMakePaliQueries("hunu", arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(0, 3, 1))))

}
