package com.leetcode


/**
 * two sets
 */
class Bitset(size: Int) {

    private val SIZE = size
    private var ones = mutableSetOf<Int>()
    private var zeros = (0 until size).toMutableSet()

    fun fix(idx: Int) {
        ones.add(idx)
        zeros.remove(idx)
    }

    fun unfix(idx: Int) {
        ones.remove(idx)
        zeros.add(idx)
    }

    fun flip() {
        val tmp = ones
        ones = zeros
        zeros = tmp
    }

    fun all(): Boolean {
        return zeros.size == 0
    }

    fun one(): Boolean {
        return ones.size > 0
    }

    fun count(): Int {
        return ones.size
    }

    override fun toString(): String {
        return (0 until SIZE).map { if (it in ones) '1' else '0' }.joinToString("")
    }

}
