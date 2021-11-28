package com.leetcode

fun wateringPlants(plants: IntArray, capacity: Int): Int {

    var ans = 1
    var now = capacity
    for (i in plants.indices) {
        now -= plants[i]
        if (i + 1 == plants.size) return ans

        if (now < plants[i + 1]) {
            now = capacity
            ans += (i + 1) * 2
        }

        ans ++
    }

    return 0
}
