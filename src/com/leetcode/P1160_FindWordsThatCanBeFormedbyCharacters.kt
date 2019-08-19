package com.leetcode


fun countCharacters(words: Array<String>, chars: String): Int {

    fun good(s: String, t: String): Boolean = ('a'..'z').all { ch -> s.count { it == ch } <= t.count {it == ch} }
    return words.sumBy { if (good(it, chars)) it.length else 0 }

}


fun main() {
}