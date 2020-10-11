package com.leetcode


/**
 * easy, basic () problem
 */
fun maxDepth(s: String): Int {
    var ans = 0
    var now = 0
    for (p in s) {
        if (p == '(') now ++
        else if(p == ')') now --

        ans = Math.max(ans, now)
    }

    return ans
}

fun main() {

    println(maxDepth("(1+(2*3)+((8)/4))+1"))

}
