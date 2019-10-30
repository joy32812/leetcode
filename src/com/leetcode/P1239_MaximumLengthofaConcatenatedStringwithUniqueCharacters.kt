package com.leetcode

import java.lang.StringBuilder


fun maxLength(arr: List<String>): Int {

    var ans = 0


    fun dfs(p: Int, now: String) {
        ans = Math.max(ans, now.length)
        if (p >= arr.size) return

        dfs(p + 1, now)

        if (arr[p].toSet().size != arr[p].length) return
        if (('a'..'z').any() { it in now && it in arr[p] }) return
        dfs(p + 1, now + arr[p])
    }

    dfs(0, "")
    return ans
}


fun main() {

    println(maxLength(listOf("yy","bkhwmpbiisbldzknpm")))
    println(maxLength(listOf("un","iq","ue")))
    println(maxLength(listOf("cha","r","act","ers")))
    println(maxLength(listOf("abcdefghijklmnopqrstuvwxyz")))

    println("Hello13!")

}
