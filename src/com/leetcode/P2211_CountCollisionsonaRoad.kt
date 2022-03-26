package com.leetcode

/**
 * one pass
 */
fun countCollisions(directions: String): Int {

    // 0 nothing
    // 1: stay
    // 2: to right
    var left = 0
    var rNum = 0
    var ans = 0

    for (c in directions) {

        if (c == 'R') {
            rNum ++
            left = 2
        }
        else if (c == 'S') {
            if (left == 2) ans += rNum
            left = 1
            rNum = 0
        } else {
            if (left == 0) {
            } else if (left == 1) {
                ans += 1
                left = 1
                rNum = 0
            } else {
                ans += rNum + 1
                left = 1
                rNum = 0
            }
        }
    }

    return ans
}

fun main() {

    println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"))

}
