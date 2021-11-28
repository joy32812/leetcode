package com.leetcode

/**
 * Brute-Force
 */
fun kMirror(k: Int, n: Int): Long {

    var ans = 0L
    var num = n

    fun addTheSum(s: String) {
        if (s == "0") return
        val ns = "" + s.toLong(k)
        if (ns != ns.reversed()) return

        ans += s.toLong(k)
        num --
    }

    fun getOdd(a: Int) {
        if (a == 0) {
            for (j in 0 until k) {
                addTheSum("" + j)
                if (num == 0) return
            }
            return
        }

        val l = ("1" + ("0").repeat(a - 1)).toLong(k)
        val r = ("" + (k - 1)).repeat(a).toLong(k)
        for (i in l..r) {
            val s = i.toString(k)
            for (j in 0 until k) {
                addTheSum(s + j + s.reversed())
                if (num == 0) return
            }
        }
    }

    fun getEven(a: Int) {
        val l = ("1" + ("0").repeat(a - 1)).toLong(k)
        val r = ("" + (k - 1)).repeat(a).toLong(k)
        for (i in l..r) {
            val s = i.toString(k)
            addTheSum(s + s.reversed())
            if (num == 0) return
        }
    }

    fun getKMirror(len: Int) {
        if (len % 2 == 1) getOdd(len / 2)
        else getEven(len / 2)
    }

    for (i in 1 until 50) {
        getKMirror(i)
        if (num == 0) break
    }

    return ans
}
