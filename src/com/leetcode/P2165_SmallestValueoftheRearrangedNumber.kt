package com.leetcode

/**
 * For getMin:
 * sort
 * if first == '0', swap the first non-zero
 */
fun smallestNumber(num: Long): Long {

    fun getMin(x: Long): Long {
        val chars = x.toString().toCharArray().sorted().toMutableList()

        val firstNonZero = chars.indexOfFirst { it != '0' }
        if (firstNonZero == -1) return 0L

        val ch = chars[0]
        chars[0] = chars[firstNonZero]
        chars[firstNonZero] = ch

        return chars.joinToString("").toLong()
    }

    fun getMax(x: Long): Long {
        return x.toString().toCharArray().sortedArrayDescending().joinToString("").toLong()
    }


    return if (num < 0) -1L * getMax(-1L * num) else getMin(num)
}

