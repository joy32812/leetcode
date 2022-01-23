package com.leetcode

/**
 * Bit-Mask
 */
fun maximumGood(statements: Array<IntArray>): Int {

    val n = statements.size
    val maskMax = (1 shl n) - 1

    fun getGoodNum(mask: Int): Int {
        val good = (0 until n).filter { (1 shl it) and mask > 0 }.toSet()

        for (x in good) {

            val nowGood = (0 until n).filter { statements[x][it] == 1 }
            if (nowGood.any { it !in good }) return 0

            val nowBad = (0 until n).filter { statements[x][it] == 0 }
            if (nowBad.any { it in good }) return 0
        }

        return good.size
    }

    return (1..maskMax).map { getGoodNum(it) }.max()!!
}

fun main() {

    println(maximumGood(
        arrayOf(
            intArrayOf(2, 2, 2, 2),
            intArrayOf(1, 2, 1, 0),
            intArrayOf(0, 2, 2, 2),
            intArrayOf(0, 0, 0, 2)
        )
    ))

}
