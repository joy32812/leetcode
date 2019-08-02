package com.leetcode



fun expand(S: String): Array<String> {


    fun helper(S: String): MutableSet<String> {
        if (S == null || S.isEmpty()) return mutableSetOf("")

        var left = mutableSetOf<String>()

        var index = 0
        if (S[0] == '{') {
            index = S.indexOf('}')
            left = S.substring(1, index).split(",").toMutableSet()
        } else {
            index = S.indexOf("{")
            if (index == -1) index = S.length
            left.add(S.substring(0, index))

            index --
        }

        val right = helper(S.substring(index + 1))

        val ans = mutableSetOf<String>()

        for (x in left) {
            for (y in right) ans.add(x + y)
        }

        return ans
    }

    return helper(S).toTypedArray().sortedArray()

}

fun main() {
    println(expand("{a,b}c{d,e}f"))
}