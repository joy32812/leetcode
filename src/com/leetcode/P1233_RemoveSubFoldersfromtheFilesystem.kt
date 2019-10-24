package com.leetcode

import java.lang.StringBuilder


fun removeSubfolders(folder: Array<String>): List<String> {

    folder.sortBy { it.length }

    val ans = mutableListOf<String>()
    val set = mutableSetOf<String>()

    for (s in folder) {

        val split = s.substring(1).split("/")
        var sb = StringBuilder("/")

        var con = false
        for (t in split) {
            sb.append(t)

            if (sb.toString() in set) {
                con = true
                break
            }

            sb.append("/")
        }

        if (!con) ans += s
        set += s
    }

    return ans
}

fun main() {

    println(removeSubfolders(arrayOf("/a","/a/b","/c/d","/c/d/e","/c/f")))

}
