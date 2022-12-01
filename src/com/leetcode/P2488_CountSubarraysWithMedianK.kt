/**
 * diff cnt
 */
fun countSubarrays(nums: IntArray, k: Int): Int {

    val diffMap = mutableMapOf<Int, Int>()

    val pos = nums.indexOf(k)

    var small = 0
    var large = 0

    for (i in pos until nums.size) {
        if (nums[i] < k) small++
        else if (nums[i] > k) large++

        val key = small - large
        diffMap[key] = diffMap.getOrDefault(key, 0) + 1
    }

    var ans = diffMap[0]!! + (diffMap[-1] ?: 0)

    small = 0
    large = 0
    for (i in pos - 1 downTo 0) {
        if (nums[i] < k) small++
        else if (nums[i] > k) large++

        val key = small - large
        ans += diffMap.getOrDefault(-key, 0)
        ans += diffMap.getOrDefault(-key - 1, 0)
    }

    return ans
}

