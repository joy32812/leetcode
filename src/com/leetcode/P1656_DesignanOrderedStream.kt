package com.leetcode

/**
 * easy
 */
class OrderedStream(n: Int) {

    val N = n
    val data = Array(N + 1) { "" }
    var ptr = 1

    fun insert(id: Int, value: String): List<String> {
        data[id] = value

        if (data[ptr].isEmpty()) return listOf()

        val result = mutableListOf<String>()
        for (i in ptr..N) {
            if (data[i].isEmpty()) {
                ptr = i
                break
            }
            result += data[i]
        }

        return result
    }

}


fun main() {
    println("Hello")
}

