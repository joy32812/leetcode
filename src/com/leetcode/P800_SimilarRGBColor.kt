package com.leetcode


fun similarRGB(color: String): String {

    fun getSimilar(c: String): String {

        val s = (0..15).map { it * 16 + it }.minBy { Math.abs(it - c.toInt(16)) }!!.toString(16)
        return (if (s.length == 1) "0" else "") + s

    }

    return "#${getSimilar(color.substring(1, 3))}${getSimilar(color.substring(3, 5))}${getSimilar(color.substring(5, 7))}"
}

fun main() {
    println(similarRGB("#09f166"))
}