package com.leetcode

/**
 * DP + presum
 * Or Slide window
 */
fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {

    val flag = Array(s.length) { 0 }
    val presum = Array(s.length) { 0 }
    flag[0] = 1
    (0 until Math.min(minJump, s.length)).forEach { presum[it] = 1 }

    fun getSum(l: Int, r: Int) = presum[r] - (if (l - 1 < 0) 0 else presum[l - 1])

    for (i in minJump until s.length) {
        if (s[i] == '1') {
            presum[i] = presum[i - 1]
            continue
        }

        val l = Math.max(0, i - maxJump)
        val r = Math.max(0, i - minJump)
        flag[i] = if(getSum(l, r) > 0) 1 else 0
        presum[i] = presum[i - 1] + flag[i]
    }

    return flag[s.length - 1] > 0
}
