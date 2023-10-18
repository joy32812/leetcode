fun findIndices(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {

    for (i in nums.indices) {
        for (j in i until nums.size) {
            if (Math.abs(nums[j] - nums[i]) >= valueDifference && j - i >= indexDifference) {
                return intArrayOf(i, j)
            }
        }
    }

    return intArrayOf(-1, -1)
}
