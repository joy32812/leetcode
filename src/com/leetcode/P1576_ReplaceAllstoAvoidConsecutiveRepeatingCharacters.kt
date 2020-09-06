package com.leetcode

/**
 * easy
 */
fun modifyString(s: String): String {
    var ans = ""

    fun getTheChar(i: Int): Char {
        for (c in 'a'..'z') {
            if ((ans.isEmpty() || c != ans.last()) && (i == s.length || s[i] == '?' || s[i] != c)) return c;
        }

        return 'a';
    }

    for (i in s.indices) {
        if (s[i] == '?') {
            ans += getTheChar(i + 1);
        } else ans += s[i];
    }

    return ans;
}



fun main() {
    println(modifyString("ubv?w"));

}
