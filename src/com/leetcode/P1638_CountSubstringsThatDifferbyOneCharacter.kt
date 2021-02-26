package com.leetcode


/**
 * count by mismatch position
 */
fun countSubstrings(s: String, t: String): Int {

    var total = 0
    for (i in s.indices) {
        for (j in t.indices) {
            if (s[i] == t[j]) continue

            var ll = 1
            while (i - ll >= 0 && j - ll >= 0 && s[i - ll] == t[j - ll]) ll ++;
            var rr = 1
            while (i + rr < s.length && j + rr < t.length && s[i + rr] == t[j + rr]) rr ++
            total += ll * rr
        }
    }

    return total
}
