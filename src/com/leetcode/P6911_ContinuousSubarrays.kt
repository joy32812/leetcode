import java.util.*

/**
 * sliding window.
 */
fun continuousSubarrays(nums: IntArray): Long {
    val treeMap = TreeMap<Int, Int>()
    var r = 0

    fun okay(x: Int): Boolean {
        if (treeMap.isEmpty()) return true

        return Math.abs(treeMap.firstKey() - x) <= 2 && Math.abs(treeMap.lastKey() - x) <= 2
    }

    var ans = 0L
    for (i in nums.indices) {
        while (r < nums.size && okay(nums[r])) {
            treeMap[nums[r]] = (treeMap[nums[r]] ?: 0) + 1
            r++
        }

        ans += r - i

        treeMap[nums[i]] = (treeMap[nums[i]] ?: 0) - 1
        if (treeMap[nums[i]] == 0) treeMap.remove(nums[i])
    }

    return ans
}

fun main() {
    println(continuousSubarrays(intArrayOf(5, 4, 2, 4)))
}
