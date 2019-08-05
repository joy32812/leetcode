package com.leetcode

import java.util.*

class SnapshotArray(length: Int) {

    var treeMaps: Array<TreeMap<Int, Int>> = Array(length) {TreeMap<Int, Int>()}
    var version = 0

    init {
        for (i in 0 until length) {
            treeMaps[i][version] = 0
        }
    }

    fun set(index: Int, `val`: Int) {
        treeMaps[index][version] = `val`
    }

    fun snap(): Int {
        return version++
    }

    fun get(index: Int, snap_id: Int): Int {
        return treeMaps[index].floorEntry(snap_id).value
    }
}
