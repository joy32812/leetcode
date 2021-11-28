package com.leetcode

/**
 * Greedy
 */
fun minimumBuckets(street: String): Int {

    fun okay(i: Int) = (i - 1 >= 0 && street[i - 1] == '.') || (i + 1 < street.length && street[i + 1] == '.')
    if (street.indices.any { i -> street[i] == 'H' && !okay(i) }) return -1

    fun getMin(s: String): Int {
        var cnt = 0
        var pos = -100

        for (i in s.indices) {
            if (s[i] == 'H') {
                if (pos == i - 1) continue
                else if (i + 1 < s.length && s[i + 1] == '.') {
                    cnt ++
                    pos = i + 1
                } else {
                    cnt ++
                    pos = i - 1
                }
            }
        }
        return cnt
    }

    return getMin(street)
}
