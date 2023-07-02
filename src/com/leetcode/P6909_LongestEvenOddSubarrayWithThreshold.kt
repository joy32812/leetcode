fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {

    fun okay(l: Int, r: Int): Boolean {
        return nums[l] % 2 == 0 &&
                (l until r).all { i -> nums[i] % 2 != nums[i + 1] % 2 } &&
                (l .. r).all { i -> nums[i] <= threshold }
    }

    var ans = 0
    for (i in nums.indices) {

        for (j in i until nums.size) {

            val len = j - i + 1
            if (len > ans && okay(i, j)) ans = len
        }

    }

    return ans
}
