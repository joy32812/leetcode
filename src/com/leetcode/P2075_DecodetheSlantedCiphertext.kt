package com.leetcode

fun decodeCiphertext(encodedText: String, rows: Int): String {
    val R = rows
    val C = encodedText.length / R

    val ans = mutableListOf<Char>()
    for (j in 0 until C) {

        var x = 0
        var y = j

        while (x >= 0 && y >= 0 && x < R && y < C) {
            ans += encodedText[x * C + y]
            x ++
            y ++
        }
    }

    return ans.joinToString("").trimEnd()
}
