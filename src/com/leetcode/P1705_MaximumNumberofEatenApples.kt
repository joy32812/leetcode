package com.leetcode

/**
 * priority queue
 */
import java.util.*
fun eatenApples(apples: IntArray, days: IntArray): Int {

    class Apple(val number: Int, val from: Int, val end: Int)
    val appleList = apples.indices.map { Apple(apples[it], it, it + days[it]) }
    val pq = PriorityQueue<Apple> { a, b -> when {
        a.end == b.end -> a.from - b.from
        else -> a.end - b.end
    }}

    var ans = 0
    val MAX_DAYS = 1_000_000
    for (day in 0 until MAX_DAYS) {
        if (day < appleList.size && appleList[day].number > 0) pq += appleList[day]

        while (!pq.isEmpty()) {
            val apple = pq.poll()
            if (day >= apple.end) continue

            ans ++
            if (apple.number - 1> 0) {
                pq += Apple(apple.number - 1, apple.from, apple.end)
            }
            break
        }

        if (day > apples.size && pq.isEmpty()) break
    }

    return ans
}

fun main() {
    println(eatenApples(intArrayOf(0,19,19,19,11,14,33,0,28,7,0,28,7,0,21,16,0,22,0,13,8,0,19,0,0,2,26,2,22,0,8,0,0,27,19,16,24,0,20,26,20,7,0,0,29,0,0,16,19,0,0,0,29,30,17,0,23,0,0,26,24,13,3,0,21,0,18,0),
            intArrayOf(0,5,1,16,7,10,54,0,40,2,0,23,4,0,20,18,0,40,0,22,8,0,35,0,0,3,24,1,8,0,10,0,0,2,38,8,4,0,36,33,14,9,0,0,56,0,0,21,27,0,0,0,14,20,18,0,42,0,0,44,3,8,3,0,10,0,27,0)))

}
