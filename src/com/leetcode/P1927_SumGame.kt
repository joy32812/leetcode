package com.leetcode

/**
 * Greedy
 */
fun sumGame(num: String): Boolean {

    val n = num.length

    var sum1 = 0
    var x = 0

    var sum2 = 0
    var y = 0
    for (i in 0 until n / 2) {
        if (num[i] == '?') x ++
        else sum1 += num[i] - '0'
    }

    for (i in n / 2 until  n) {
        if (num[i] == '?') y ++
        else sum2 += num[i] - '0'
    }

    if ((x + y) % 2 == 1) return true



    fun canSmaller(s1: Int, n1: Int, s2: Int, n2: Int): Boolean {

        var ss1 = s1
        var nn1 = n1
        var ss2 = s2
        var nn2 = n2

        var isAlice = true

        while (nn1 > 0 || nn2 > 0) {
            if (isAlice) {
                if (nn2 > 0) {
                    ss2 += 9
                    nn2 --
                } else {
                    nn1 --
                }
            } else {

                if (nn1 > 0) {
                    ss1 += 9
                    nn1 --
                } else {
                    nn2 --
                }

            }

            isAlice = !isAlice
        }

        return ss1 < ss2
    }

    return canSmaller(sum1, x, sum2, y) || canSmaller(sum2, y, sum1, x)
}

fun main() {
    println(sumGame("25??"))
}
