package com.leetcode


fun freqAlphabets(s: String): String {
    var ans = s
    (10..26).forEach { ans = ans.replace("${it}#", ('j' + it - 10) + "") }
    (1..9).forEach { ans = ans.replace("${it}", ('a' + it - 1) + "") }
    return ans
}
