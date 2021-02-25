package com.leetcode

/**
 * greedy
 */
fun maximumGain(s: String, x: Int, y: Int): Int {
    var ans = 0
    var i = 0

    fun work(l: Int, r: Int): Int {
        var range = if (x > y) l..r else r downTo l
        var aNum = 0
        var cnt = 0

        for (i in range) {
            if (s[i] == 'a') aNum ++
            else if (aNum > 0) {
                aNum --
                cnt ++
            }
        }

        val aTotalNum = (l..r).count { s[it] == 'a' }
        val bTotalNum = (l..r).count { s[it] == 'b' }
        return cnt * Math.max(x, y) + (Math.min(aTotalNum, bTotalNum) - cnt) * Math.min(x, y)
    }

    while (i < s.length) {
        if (s[i] != 'a' && s[i] != 'b') {
            i++
            continue
        }

        var j = i
        while (j < s.length && (s[j] == 'a' || s[j] == 'b')) j++

        ans += work(i, j - 1)
        i = j
    }

    return ans
}

fun main() {

    println(maximumGain("cdbcbbaaabab", 4, 5))

}
