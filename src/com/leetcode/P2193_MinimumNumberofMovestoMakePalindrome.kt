package com.leetcode

/**
 * greedy
 */
fun minMovesToMakePalindrome(s: String): Int {

    var l = 0
    var r = s.length - 1
    val arr = s.toCharArray()

    fun swap(x: Int, y: Int) {
        val tmp = arr[x]
        arr[x] = arr[y]
        arr[y] = tmp
    }

    var ans = 0
    while (l < r) {
        if (arr[l] == arr[r]) {
            l ++
            r --
            continue
        }

        var p = r
        while (p > l && arr[p] != arr[l]) p --

        if (p == l) {
            swap(l, l + 1)
            ans ++
        } else {
            while (p < r) {
                swap(p, p + 1)
                p ++
                ans ++
            }
        }
    }

    return ans
}
