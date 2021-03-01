package com.leetcode

/**
 * DP
 */
fun bestTeamScore(scores: IntArray, ages: IntArray): Int {

    class Member(val age: Int, val score: Int)
    val members = scores.indices.map { Member(ages[it], scores[it]) }.sortedWith(compareBy({ it.age }, { it.score }))

    val dp = Array(scores.size) { 0 }
    for (i in members.indices) {
        dp[i] = members[i].score
        for (j in 0 until i) {
            if (members[i].score >= members[j].score) dp[i] = Math.max(dp[i], dp[j] + members[i].score)
        }
    }

    return dp.max()!!
}

