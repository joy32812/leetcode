import java.util.*

/**
 * TreeMap
 */
fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {
    var ans = Int.MAX_VALUE
    val treeSet = TreeSet<Int>()

    for (i in nums.indices) {
        treeSet += nums[i]

        val j = i + x
        if (j >= nums.size) break

        val floor = treeSet.floor(nums[j])
        if (floor != null) {
            ans = minOf(ans, nums[j] - floor)
        }

        val ceiling = treeSet.ceiling(nums[j])
        if (ceiling != null) {
            ans = minOf(ans, ceiling - nums[j])
        }
    }

    return ans
}
