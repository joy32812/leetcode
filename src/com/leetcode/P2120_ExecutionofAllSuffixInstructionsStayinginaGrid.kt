package com.leetcode

/**
 * brute force
 */
fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {

    fun inGrid(x: Int, y: Int) = x in 0 until n && y in 0 until n
    fun getLen(si: Int): Int {
        var ans = 0

        var (x, y) = startPos
        for (i in si until s.length) {

            if (s[i] == 'L') {
                y --
            } else if (s[i] == 'R') {
                y ++
            } else if (s[i] == 'U') {
                x --
            } else {
                x ++
            }

            if (!inGrid(x, y)) return ans
            ans ++
        }

        return ans
    }


    return s.indices.map { getLen(it) }.toIntArray()
}
