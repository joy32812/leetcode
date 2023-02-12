/**
 * binary search.
 */
fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
    nums.sort()

    fun getFirstIndex(d: Int): Int {
        if (d <= nums[0]) return 0
        if (d > nums[nums.size - 1]) return nums.size

        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val m = (l + r) / 2
            if (nums[m] >= d) r = m
            else l = m + 1
        }

        return l
    }

    return nums.map {
        val l = getFirstIndex(lower - it)
        val u = getFirstIndex(upper + 1 - it)

        0L + u - l - (if (it * 2 in lower..upper) 1 else 0)

    }.sum() / 2


}

fun main() {
    // nums = [1,7,9,2,5], lower = 11, upper = 11
    println(countFairPairs(intArrayOf(1,7,9,2,5), 11, 11))
}