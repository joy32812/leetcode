package com.leetcode


fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {

    var now = calories.withIndex().filter { it.index < k }.sumBy { it.value }
    var ans = if (now < lower) -1 else if (now > upper) 1 else 0
    for (i in k until calories.size) {
        now += calories[i] - calories[i - k]
        ans += if (now < lower) -1 else if (now > upper) 1 else 0
    }

    return ans
}


fun main() {

}
