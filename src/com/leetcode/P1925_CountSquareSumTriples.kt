package com.leetcode

/**
 * brute force
 */
fun countTriples(n: Int): Int {

    var ans = 0
    for (i in 1..n) {
        for (j in 1..n) {
            for (k in 1..n) {
                if (i * i + j * j == k * k) ans ++
            }
        }
    }

    return ans

}
