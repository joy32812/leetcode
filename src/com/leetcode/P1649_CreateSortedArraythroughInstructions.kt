package com.leetcode

/**
 * Binary indexed tree
 */
fun createSortedArray(instructions: IntArray): Int {
    var MOD = 1_000_000_000 + 7

    val N = 1_000_00 + 5
    val BITSmall = Array(N) {0}
    val BITBig = Array(N) {0}



    fun updateSmall(d: Int) {
        var x = d
        while (x < BITSmall.size) {
            BITSmall[x] ++
            x += (x and -x)
        }
    }

    fun querySmall(d: Int): Int {
        var x = d
        var res = 0
        while (x > 0) {
            res += BITSmall[x]
            x -= (x and -x)
        }
        return res
    }

    fun updateBig(d: Int) {
        var x = d
        while (x > 0) {
            BITBig[x] ++
            x -= (x and -x)
        }
    }
    fun queryBig(d: Int): Int {
        var x = d
        var res = 0
        while (x < BITBig.size) {
            res += BITBig[x]
            x += (x and -x)
        }
        return res
    }

    var ans = 0L
    for (d in instructions) {
        val smallNum = querySmall(d - 1)
        val bigNum = queryBig(d + 1)
        ans = (ans + Math.min(smallNum, bigNum)) % MOD

        updateBig(d)
        updateSmall(d)
    }

    return ans.toInt()
}

fun main() {
    println("Hello")
}
