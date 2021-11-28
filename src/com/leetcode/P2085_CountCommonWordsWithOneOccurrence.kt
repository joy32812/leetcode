package com.leetcode

fun countWords(words1: Array<String>, words2: Array<String>): Int {
    return words1.toSet().intersect(words2.toSet()).count { s -> words1.count { it == s } == 1 && words2.count { it == s } == 1 }
}
