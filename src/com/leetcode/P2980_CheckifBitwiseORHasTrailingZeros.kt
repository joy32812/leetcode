fun hasTrailingZeros(nums: IntArray): Boolean {

    return nums.count { it % 2 == 0 } >= 2

}
