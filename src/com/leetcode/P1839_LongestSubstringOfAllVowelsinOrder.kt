package com.leetcode

/**
 * easy
 */
fun longestBeautifulSubstring(word: String): Int {

    class Node(val ch: Char, val num: Int);
    val data = mutableListOf<Node>()

    var ch = word[0]
    var num = 1
    for (i in 1 until word.length) {
        if (word[i] != ch) {
            data += Node(ch, num)
            ch = word[i]
            num = 1
        } else num++
    }
    data += Node(ch, num)

    var ans = 0
    for (i in 4 until data.size) {
        if (data[i - 4].ch == 'a' && data[i - 3].ch == 'e' && data[i - 2].ch == 'i' && data[i - 1].ch == 'o' && data[i].ch == 'u') {
            ans = Math.max(
                ans,
                data[i - 4].num + data[i - 3].num + data[i - 2].num + data[i - 1].num + data[i].num
            )
        }
    }

    return ans
}

