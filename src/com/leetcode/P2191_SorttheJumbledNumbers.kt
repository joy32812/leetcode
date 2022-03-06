package com.leetcode

/**
 * sortedWith
 * compareBy
 */
fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {

    class Entry(val d: Int, val i: Int, val t: Int)

    fun getJumbled(d: Int) = d.toString().map { '0' + mapping[it - '0'] }.joinToString("").toInt()

    return nums.mapIndexed { index, d -> Entry(d, index, getJumbled(d)) }.sortedWith(compareBy({it.t}, {it.i})).map { it.d }.toIntArray()

}

