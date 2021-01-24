package com.leetcode

fun minCharacters(a: String, b: String): Int {


    fun minForLess(aa: String, bb: String): Int {
        val cntA = Array(26) {0}
        val cntB = Array(26) {0}
        aa.forEach { cntA[it - 'a']++ }
        bb.forEach { cntB[it - 'a']++ }

        var ans = Int.MAX_VALUE
        for (now in 0..24) {
            var tmp = cntA.filterIndexed { index, i -> index > now }.sum() + cntB.filterIndexed { index, i -> index <= now }.sum()
            ans = Math.min(ans, tmp)
        }
        return ans
    }

    fun minForEqual(aa: String, bb: String): Int {
        val cntA = Array(26) {0}
        val cntB = Array(26) {0}
        aa.forEach { cntA[it - 'a']++ }
        bb.forEach { cntB[it - 'a']++ }

        return (0..25).map { cntA.sum() - cntA[it] + cntB.sum() - cntB[it] }.min()!!
    }

    var result = Math.min(minForLess(a, b), minForLess(b, a)) // condition 1 && 2
    return Math.min(result, minForEqual(a, b)) // condition 3
}

fun main() {

}

