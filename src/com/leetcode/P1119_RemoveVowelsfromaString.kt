package com.leetcode


fun removeVowels(S: String): String {

    return S.filter { !(it  in "aeiou") }.toString()

}