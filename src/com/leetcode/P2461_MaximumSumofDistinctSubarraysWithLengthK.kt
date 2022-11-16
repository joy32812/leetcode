/**
 * sliding window.
 */
fun maximumSubarraySum(nums: IntArray, k: Int): Long {

    var ans = 0L
    var sum = 0L
    var numMap = mutableMapOf<Int, Int>()

    for (i in 0 until k) {
        sum += nums[i]
        numMap[nums[i]] = numMap.getOrDefault(nums[i], 0) + 1
    }

    if (numMap.size == k) ans = sum

    fun remove(i: Int) {
        sum -= nums[i]
        numMap[nums[i]] = numMap.getOrDefault(nums[i], 0) - 1
        if (numMap[nums[i]] == 0) numMap.remove(nums[i])
    }

    fun add(i: Int) {
        sum += nums[i]
        numMap[nums[i]] = numMap.getOrDefault(nums[i], 0) + 1
    }

    for (i in k until nums.size) {

        remove(i - k)
        add(i)

        if (numMap.size == k) ans = maxOf(ans, sum)
    }

    return ans
}
