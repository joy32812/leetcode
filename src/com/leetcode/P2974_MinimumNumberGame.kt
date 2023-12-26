fun numberGame(nums: IntArray): IntArray {
    return nums.sorted().chunked(2).flatMap { listOf(it[1], it[0]) }.toIntArray()
}
