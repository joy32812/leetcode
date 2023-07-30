fun countCompleteSubarrays(nums: IntArray): Int {

    val n = nums.size
    var ans = 0
    val total = nums.toSet().size

    for (i in 0 until n) {
        val set = mutableSetOf<Int>()

        for (j in i until n) {
            set += nums[j]
            if (set.size == total) ans++
        }
    }

    return ans
}
