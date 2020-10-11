package com.leetcode

/**
 * O(n) greedy
 */
fun checkPalindromeFormation(a: String, b: String): Boolean {

    fun isPalindrome(z: String, i: Int, j: Int): Boolean {
        var s = i
        var e = j
        while (s < e && z[s] == z[e]) {
            s ++
            e --
        }

        return s >= e
    }

    fun check(x: String, y: String): Boolean {
        var i = 0
        var j = x.length - 1

        while (i < j && x[i] == y[j]) {
            i ++
            j --
        }

        return isPalindrome(x, i, j) || isPalindrome(y, i, j);
    }

    return check(a, b) || check(b, a)
}

fun main() {
    println(checkPalindromeFormation("ulacfd", "jizalu"))
}
