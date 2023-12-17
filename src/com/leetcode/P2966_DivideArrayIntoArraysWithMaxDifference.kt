/**
 * greedy
 */
fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    nums.sort()

    val result = mutableListOf<IntArray>()

    for (i in nums.indices step 3) {
        val a = nums[i]
        val b = nums[i + 1]
        val c = nums[i + 2]

        if (c - a > k) return emptyArray()
        result.add(intArrayOf(a, b, c))
    }

    return result.toTypedArray()
}
