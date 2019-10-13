package com.leetcode


/**
 * dfs recursion
 */
fun countSteppingNumbers(low: Int, high: Int): List<Int> {
    val ans = mutableSetOf<Int>()

    fun dfs(now: Long, ll: Long, rr: Long) {
        if (now in ll..rr) {
            ans += now.toInt()
        }

        if (now.toInt() == 0 || now > rr) return

        val last = (now % 10).toInt()

        if (last - 1 in 0..9) {
            dfs(now * 10 + last - 1, ll, rr)
        }

        if (last + 1 in 0..9) {
            dfs(now * 10 + last + 1, ll, rr)
        }
    }

    for (i in 0..9) {
        dfs(i.toLong(), low.toLong(), high.toLong())
    }

    return ans.toList().sorted()
}

fun main() {

    println(countSteppingNumbers(0, 1_000_000_000))


}
