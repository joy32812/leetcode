package com.leetcode

/**
 * Count half
 */
fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {

    val half = intLength / 2
    val mid = intLength - half * 2

    fun getMin(): Long {
        var ans = 1L
        for (i in 1 until half) ans *= 10
        return ans
    }

    fun getMax(): Long {
        return getMin() * 10 - 1
    }

    fun getPali(h: Long): Long {
        return (h.toString() + h.toString().reversed()).toLong()
    }

    fun getPaliWithMid(h: Long, m: Long): Long {
        return (h.toString() + m.toString() + h.toString().reversed()).toLong()
    }


    fun getAns(q: Long): Long {
        if (half == 0) return if (q >= 10) -1L else q

        var total = getMax() - getMin() + 1
        if (mid == 1) total *= 10

        if (q > total) return -1L
        if (mid == 0)  return getPali(getMin() + q - 1)
        return getPaliWithMid(getMin() + (q - 1)/ 10, (q - 1) % 10)
    }

    return queries.map { getAns(it.toLong()) }.toLongArray()

}

fun main() {
    println(kthPalindrome(
        intArrayOf(90),
        3
    ))
}
