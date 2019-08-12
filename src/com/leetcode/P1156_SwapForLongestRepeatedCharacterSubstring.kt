package com.leetcode


fun maxRepOpt1(text: String): Int {
    val groupBy = text.groupBy { it }

    val charList = mutableListOf<Char>()
    val numList = mutableListOf<Int>()

    var lastChar = '#'
    var cnt = 0
    for (i in 0 until text.length) {
        if (text[i] != lastChar) {
            if (lastChar != '#') {
                charList.add(lastChar)
                numList.add(cnt)
            }

            lastChar = text[i]
            cnt = 1
        } else {
            cnt++
        }
    }
    if (lastChar != '#') {
        charList.add(lastChar)
        numList.add(cnt)
    }


    var ans = numList.max()!!
    for (i in 1 until charList.size - 1) {
        if (numList[i] == 1) {
            if (charList[i - 1] == charList[i + 1]) {
                var now = numList[i - 1] + numList[i + 1]
                if (groupBy[charList[i - 1]]!!.size > now) {
                    now ++
                }
                ans = Math.max(ans, now)
            }
        } else {
            var now = numList[i - 1]
            if (groupBy[charList[i - 1]]!!.size > now) {
                now ++
            }
            ans = Math.max(ans, now)

            now = numList[i + 1]
            if (groupBy[charList[i + 1]]!!.size > now) {
                now ++
            }
            ans = Math.max(ans, now)
        }
    }

    return ans
}

fun main() {
    println(maxRepOpt1("babbaaabbbbbaa"))
//    println(maxRepOpt1("ababa"))
//    println(maxRepOpt1("aaabaaa"))
//    println(maxRepOpt1("aaabbaaa"))
//    println(maxRepOpt1("aaaaa"))
//    println(maxRepOpt1("abcdef"))

}
