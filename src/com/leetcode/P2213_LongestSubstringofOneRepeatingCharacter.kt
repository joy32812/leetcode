package com.leetcode

import java.util.TreeMap

/**
 * Tow TreeMap
 * Segment merge
 */
fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
    val chars = s.toCharArray()
    val lens = TreeMap<Int, Int>()
    val segs = TreeMap<Int, Int>()

    fun add(l: Int, r: Int) {
        segs[l] = r
        val len = r - l + 1
        lens[len] = (lens[len] ?: 0) + 1
    }

    fun remove(l: Int) {
        val len = segs[l]!! - l + 1
        lens[len] = (lens[len] ?: 0) - 1
        if (lens[len] == 0) lens.remove(len)
        segs.remove(l)
    }

    var l = 0
    var i = 0
    while (i < s.length) {
        if (s[i] == s[l]) i ++
        else {
            add(l, i - 1)
            l = i
        }
    }
    add(l, s.length - 1)


    fun mergeCeiling(p: Int) {
        if (p == s.length - 1) return
        if (chars[p] != chars[p + 1]) return

        val left = segs.floorEntry(p)
        val right = segs.floorEntry(p + 1)

        remove(left.key)
        remove(right.key)

        add(left.key, right.value)
    }

    fun mergeFloor(p: Int) {
        if (p == 0) return
        if (chars[p] != chars[p - 1]) return

        val floor = segs.floorEntry(p - 1)
        remove(p)
        remove(floor.key)

        add(floor.key, floor.value + 1)
    }

    val ans = mutableListOf<Int>()
    for (i in queryCharacters.indices) {
        val index = queryIndices[i]
        val ch = queryCharacters[i]

        val floor = segs.floorEntry(index)
        remove(floor.key)

        // left
        if (floor.key < index) add(floor.key, index - 1)

        // mid
        chars[index] = ch
        add(index, index)

        // right
        if (index < floor.value) add(index + 1, floor.value)

        mergeFloor(index)
        mergeCeiling(index)

        ans += lens.lastKey()
    }

    return ans.toIntArray()
}

fun main() {
    println(longestRepeating("babacc", "bcb", intArrayOf(1, 3, 3)))
}

