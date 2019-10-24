package com.leetcode


fun balancedString(s: String): Int {


    val countMap = mutableMapOf<Char, Int>()
    "QWER".forEach { ch -> countMap[ch] = s.count { it == ch } }


    var l = 0
    var r = -1
    val nowMap = mutableMapOf(
            'Q' to 0,
            'W' to 0,
            'E' to 0,
            'R' to 0
    )

    var ans = Int.MAX_VALUE

    fun okay(): Boolean {
        return "QWER".all { countMap[it]!! - nowMap[it]!! <= s.length / 4 }
    }

    while (true) {

        while (true) {
            if (okay()) {
                ans = Math.min(ans, r - l + 1)
                println("" + ans + " " + l + " " + r)
                if (l >= r) break

                nowMap[s[l]] = nowMap[s[l]]!! - 1
                l ++
            }
            else {
                break
            }
        }

        r++
        if (r >= s.length) break
        nowMap[s[r]] = nowMap[s[r]]!! + 1
    }

    return ans
}


fun main() {

    println(balancedString("WWEQERQWQWWRWWERQWEQ"))
//    println(balancedString("WWQQRRRRQRQQ"))
//    println(balancedString("QWER"))
//    println(balancedString("QQWE"))
//    println(balancedString("QQQW"))
//    println(balancedString("QQQQ"))

}
