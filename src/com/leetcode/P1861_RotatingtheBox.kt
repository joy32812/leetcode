package com.leetcode

/**
 * simulate
 */
fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
    val m = box.size
    val n = box[0].size

    val ans = Array(n) { Array(m) { '.' } }

    for (i in 0 until m) {
        val stick = mutableListOf<Char>()
        var emptyNum = 0
        for (j in n - 1 downTo 0) {
            if (box[i][j] =='.') emptyNum ++
            else if (box[i][j] == '#') {
                stick += '#'
            } else {
                repeat(emptyNum) { stick += '.' }
                emptyNum = 0
                stick += '*'
            }
        }


        repeat(emptyNum) { stick += '.' }

        for (j in 0 until n) {
            ans[n - j - 1][m - i - 1] = stick[j]
        }
    }

    return ans.map { it.toCharArray() }.toTypedArray()
}
