/**
 * find max from left and right. then iterate through the array and find the max result.
 */
fun maximumTripletValue2(nums: IntArray): Long {
    val n = nums.size

    fun getMaxFromLeft(): IntArray {
        val maxFromLeft = IntArray(n)
        var max = nums[0]
        for (i in 0 until n) {
            max = maxOf(max, nums[i])
            maxFromLeft[i] = max
        }
        return maxFromLeft
    }

    fun getMaxFromRight(): IntArray {
        val maxFromRight = IntArray(n)
        var max = nums[n - 1]
        for (i in n - 1 downTo 0) {
            max = maxOf(max, nums[i])
            maxFromRight[i] = max
        }
        return maxFromRight
    }

    val maxFromLeft = getMaxFromLeft()
    val maxFromRight = getMaxFromRight()
    var ans = 0L
    for (i in 1 until n - 1) {
        val maxLeft = maxFromLeft[i - 1]
        val maxRight = maxFromRight[i + 1]

        ans = maxOf(
            ans,
            1L * (maxLeft - nums[i]) * maxRight
        )
    }

    return ans
}
