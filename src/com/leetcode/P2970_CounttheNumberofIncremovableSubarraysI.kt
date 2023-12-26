fun incremovableSubarrayCount(nums: IntArray): Int {

    fun okay(range: IntRange): Boolean {
        val list = nums.withIndex().filterNot { it.index in range }.map { it.value }

        // check if list is strictly increasing
        for (i in 1 until list.size) {
            if (list[i] <= list[i - 1]) return false
        }
        return true
    }

    var ans = 0
    for (i in nums.indices) {
        for (j in i until nums.size) {
            if (okay(i..j)) ans ++
        }

    }

    return ans

}
