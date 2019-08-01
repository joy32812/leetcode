package com.leetcode



val ansSet = mutableSetOf<String>()
val visitSet = mutableSetOf<Int>()
fun numTilePossibilities(tiles: String): Int {

    nowDfs(tiles, "")

    return ansSet.size

}

fun nowDfs(tiles: String, current: String) {
    if (current != "") ansSet.add(current)

    for (i in 0 until tiles.length) {
        if (visitSet.contains(i)) continue
        visitSet.add(i)
        nowDfs(tiles, current + tiles[i])
        visitSet.remove(i)
    }

}
