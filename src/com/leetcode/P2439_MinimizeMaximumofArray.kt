/**
 * classic binary search.
 */
fun minimizeArrayValue(nums: IntArray): Int {
    var l = 0
    var r = nums.maxOrNull() ?: 0

    fun okay(x: Int): Boolean {
        var delta = 0L
        for (i in nums.indices.reversed()) {
            delta = if (nums[i] + delta > x) {
                nums[i] + delta - x
            } else {
                0
            }
        }
        return delta == 0L
    }

    while (l < r) {
        val m = (l + r) / 2

        if (okay(m)) r = m
        else l = m + 1
    }

    return l
}
