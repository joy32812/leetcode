/**
 * greedy.
 */
fun largestPerimeter(nums: IntArray): Long {

    val sorted = nums.sorted()

    val presum = Array(sorted.size) { 0L }
    presum[0] = sorted[0].toLong()
    for (i in 1 until sorted.size) {
        presum[i] = presum[i - 1] + sorted[i]
    }

    var ans = -1L
    for (i in 2 until sorted.size) {
        if (presum[i - 1] > sorted[i]) {
            ans = maxOf(ans, presum[i - 1] + sorted[i])
        }
    }

    return ans
}

fun main() {
    // [5,5,50]
    println(largestPerimeter(intArrayOf(5, 5, 50)))
}
