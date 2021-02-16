package com.leetcode

/**
 * Prime factorization + get combinations
 * Stars and bars
 * Distinguishable stars
 */
fun waysToFillArray(queries: Array<IntArray>): IntArray {
    val MOD = 1000_000_000 + 7
    val primeNums = mutableListOf(
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
    )

    fun getDividers(n: Int): Map<Int, Int> {
        var tmpN = n
        val ans = mutableMapOf<Int, Int>()
        for (d in primeNums) {
            if (tmpN % d != 0) continue
            var cnt = 0
            while (tmpN % d == 0) {
                cnt ++
                tmpN /= d
            }
            ans[d] = cnt
        }
        if (tmpN > 1) ans[tmpN] = 1
        return ans
    }

    val combMap = mutableMapOf<String, Int>()
    fun getComb(a: Int, b: Int): Int {
        if (a == b || b == 0) return 1
        val key = "" + a + "_" + b
        if (key in combMap) return combMap[key]!!

        val result = (getComb(a - 1, b) + getComb(a - 1, b - 1)) % MOD
        combMap[key] = result
        return result
    }

    fun work(n: Int, k: Int): Int {
        if (n == 1 || k == 1) return 1
        var result = 1L
        for ((_, cnt) in getDividers(n)) {
            result = result * getComb(k - 1 + cnt, cnt) % MOD
        }
        return result.toInt()
    }

    return queries.map { work(it[1], it[0]) }.toIntArray()
}

fun main() {
    println(waysToFillArray(
            arrayOf(
                    intArrayOf(73, 660),
                    intArrayOf(306,256)
            )
    ).toList())
}
