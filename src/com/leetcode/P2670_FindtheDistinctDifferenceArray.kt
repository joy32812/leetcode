fun distinctDifferenceArray(nums: IntArray): IntArray {

    fun rangeUniqueSize(r: IntRange) = nums.toList().subList(r.first, r.last + 1).toSet().size
    fun getDiff(i: Int) = rangeUniqueSize(0..i) - rangeUniqueSize(i + 1 until nums.size)

    return nums.indices.map { getDiff(it) }.toIntArray()
}
