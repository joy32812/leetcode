package com.leetcode

/**
 * Sliding Window
 * 1. define r
 * 2. for (i in l..r)
 * 3.  while ++r
 */
fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {

    tiles.sortBy { it[0] }
    fun getMax(): Int {
        var r = 0
        var sum = 0
        var ans = 0
        for (l in tiles.indices) {
            while (r < tiles.size && tiles[r][1] - tiles[l][0] + 1 <= carpetLen) {
                sum += tiles[r][1] - tiles[r][0] + 1
                r++
            }
            ans = maxOf(ans, sum)
            if (r < tiles.size) ans = maxOf(ans, sum + carpetLen + tiles[l][0] - tiles[r][0])

            sum -= tiles[l][1] - tiles[l][0] + 1
        }

        return ans
    }

    return getMax()
}

