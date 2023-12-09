/**
 * Sliding window.
 */
fun maxSubarrayLength(nums: IntArray, k: Int): Int {

    val freqMap = mutableMapOf<Int, Int>()

    var ans = 0

    var j = 0
    for (i in nums.indices) {

        while (j < nums.size && (freqMap[nums[j]] ?: 0) < k) {
            freqMap[nums[j]] = (freqMap[nums[j]] ?: 0) + 1
            j++
        }

        ans = maxOf(ans, j - i)
        freqMap[nums[i]] = freqMap[nums[i]]!! - 1
    }

    return ans
}


fun main() {
    // nums = [1,2,3,1,2,3,1,2], k = 2
    println(maxSubarrayLength(intArrayOf(1, 2, 3, 1, 2, 3, 1, 2), 2))
}
