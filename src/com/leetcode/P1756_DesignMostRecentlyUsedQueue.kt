package com.leetcode

class MRUQueue(n: Int) {

    var size = n
    val data = Array(n + 2010) {0}
    init {
        (0 until n).forEach { data[it] = it + 1 }
    }


    fun bs(k: Int): Int {
        fun getNums(index: Int): Int { return (0..index).count { data[it] != 0 } }

        var l = 0
        var r = data.size - 1
        while (l < r) {
            val m = (l + r) / 2;
            if (getNums(m) >= k) r = m
            else l = m + 1
        }
        return l
    }

    fun fetch(k: Int): Int {
        val index = bs(k)
        val ans = data[index]
        data[size] = data[index]
        data[index] = 0
        size++

        return ans
    }

}

fun main() {

    val obj = MRUQueue(8)

    println(obj.fetch(3))
    println(obj.fetch(5))
    println(obj.fetch(2))
    println(obj.fetch(8))

}

