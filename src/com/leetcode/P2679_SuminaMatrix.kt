fun matrixSum(nums: Array<IntArray>): Int {
    val m = nums.size
    val n = nums[0].size

    for (i in 0 until m) nums[i].sort()

    return (0 until n).sumOf { j ->
        (0 until m).maxOf { i -> nums[i][j] }
    }
}
