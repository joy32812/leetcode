package com.leetcode



fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
    val (s,t) = when {
        start <= destination -> Pair(start, destination)
        else -> Pair(destination, start)
    }

    val now = distance.toList().subList(s, t).sum()
    return Math.min(now, distance.sum() - now)
}


fun main() {

    println("Hello, World!")

}