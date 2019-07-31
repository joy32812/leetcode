package com.leetcode


fun indexPairs(text: String, words: Array<String>): Array<IntArray> {


    val ans = arrayListOf<IntArray>()

    for (i in 0 until text.length) {
        for (j in i until text.length) {
            val now = text.substring(i, j + 1)
            if (now in words) ans.add(intArrayOf(i, j))
        }
    }

    return ans.toTypedArray()
}