package com.leetcode


/**
 * DP + memo
 */
fun isValidPalindrome(s: String, k: Int): Boolean {

    val result = mutableMapOf<Pair<Int, Int>, Int>()

    fun okay(now: String, l: Int, r: Int): Int {
        if (l >=r) return 0
        if (Pair(l, r) in result) return result[Pair(l, r)]!!

        val ans = if (now[l] == now[r]) okay(now, l + 1, r - 1)
        else 1 + Math.min(okay(now, l + 1, r), okay(now, l, r - 1))

        result[Pair(l, r)] = ans
        return ans
    }

    return okay(s, 0, s.length - 1) <= k
}

fun main() {
    println(isValidPalindrome("bacabaaa", 2))
    println(isValidPalindrome("abbababa", 1))
    println(isValidPalindrome("abcdeca", 2))
    println(isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd",216))
}
