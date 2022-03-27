package com.leetcode

/**
 * DFS
 * top-down
 * memo
 */
fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {

    val ansMap = mutableMapOf<Int, Int>()
    fun dfs(p: Int, t: Int): Int {
        val z = p * 10000 + t
        if (z in ansMap) return ansMap[z]!!

        if (t == 0) return 0
        if (p == piles.size) return Int.MIN_VALUE

        var ans = dfs(p + 1, t)
        var sum = 0
        for (j in piles[p].indices) {
            if (j == t) break

            sum += piles[p][j]

            ans = Math.max(
                ans,
                sum + dfs(p + 1, t - j - 1)
            )
        }

        ansMap[z] = ans
        return ans
    }

    return dfs(0, k)
}
