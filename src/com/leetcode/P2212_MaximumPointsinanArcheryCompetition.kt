package com.leetcode

/**
 * brute force
 *
 * bit-mask
 */
fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {

    fun getScore(mask: Int): Int {

        var score = 0
        var cnt = 0
        for (i in 0 until 12) {
            if ((mask and (1 shl i) == 0)) continue
            cnt += aliceArrows[i] + 1
            score += i
        }

        return if (cnt > numArrows) 0 else score
    }

    val m = (0 until (1 shl 12)).maxBy { getScore(it) }!!


    val ans = IntArray(12) { 0 }
    for (i in 1 until 12) {
        if ((m and (1 shl i) == 0)) continue
        ans[i] = aliceArrows[i] + 1
    }

    ans[0] = numArrows - ans.sum()
    return ans
}
