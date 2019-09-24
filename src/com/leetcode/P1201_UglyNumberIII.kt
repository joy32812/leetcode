package com.leetcode

/**
 * binary search
 * set
 */
fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {

    fun gcd(a: Long, b: Long): Long = if (a % b == 0L) b else gcd(b, a % b)
    fun lowCommon(a: Long, b: Long): Long = a * b / gcd(a, b)
    fun lowCommon(a: Long, b: Long, c: Long): Long = lowCommon(lowCommon(a, b), c)

    fun cal(x: Long, div: Long): Long = x / div
    fun okay(x: Long): Boolean {
        var cnt = cal(x, a.toLong()) + cal(x, b.toLong()) + cal(x, c.toLong()) - cal(x, lowCommon(a.toLong(), b.toLong())) - cal(x, lowCommon(a.toLong(), c.toLong())) - cal(x, lowCommon(b.toLong(), c.toLong())) + cal(x, lowCommon(a.toLong(), b.toLong(), c.toLong()))
        return cnt >= n
    }


    // binary search
    var low = 1L
    var high = Int.MAX_VALUE.toLong()
    while (low < high) {
        val mid = (low + high) / 2
        if (okay(mid)) high = mid
        else low = mid + 1
    }
    return low.toInt()
}

fun main() {

    println(nthUglyNumber(3, 2, 3, 5))
    println(nthUglyNumber(4, 2, 3, 4))
    println(nthUglyNumber(5, 2, 11, 13))
    println(nthUglyNumber(1000000000, 2, 217983653, 336916467))
    println(nthUglyNumber(1000000000, 2, 685586015, 576494070))



}
