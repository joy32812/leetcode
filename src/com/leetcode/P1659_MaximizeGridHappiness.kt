package com.leetcode

/**
 * DP
 * for each cell, we only need the state of preview (n) cell
 */
fun getMaxGridHappiness(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
    val dpMap = mutableMapOf<String, Int>()

    fun calScore(now: Char, neighbor: Char): Int {
        var ans = 0
        if (now == '1' && neighbor != '0') ans -= 30
        if (now == '2' && neighbor != '0') ans += 20
        if (neighbor == '1' && now != '0') ans -= 30
        if (neighbor == '2' && now != '0') ans += 20
        return ans
    }


    fun helper(pos: Int, introNum: Int, extroNum: Int, state: String): Int {
        val x = pos / n
        val y = pos % n
        val key = state + "_" + pos + "_" + introNum + "_" + extroNum

        if (x == m || extroNum + introNum == 0) return 0
        if (key in dpMap) return dpMap[key]!!

        var now = 0;
        // empty
        now = Math.max(now, helper(pos + 1, introNum, extroNum, state.substring(1) + "0"))


        // intro
        if (introNum > 0) {
            // up
            var tmpScore = 120 + calScore('1', state[0])

            // left
            if (y - 1 >= 0) tmpScore += calScore('1', state[n - 1])
            now = Math.max(now, tmpScore + helper(pos + 1, introNum - 1, extroNum, state.substring(1) + "1"))
        }

        // extro
        if (extroNum > 0) {
            // up
            var tmpScore = 40 + calScore('2', state[0])

            // left
            if (y - 1 >= 0) tmpScore += calScore('2', state[n - 1])
            now = Math.max(now, tmpScore + helper(pos + 1, introNum, extroNum - 1, state.substring(1) + "2"))
        }

        dpMap[key] = now
        return now
    }

    return helper(0, introvertsCount, extrovertsCount, "0".repeat(n))
}

fun main() {
    println(getMaxGridHappiness(2, 2, 3, 2))
//    println(getMaxGridHappiness(3, 1, 2, 1))
//    println(getMaxGridHappiness(2, 3, 1, 2))
//    println("Hello")
}

