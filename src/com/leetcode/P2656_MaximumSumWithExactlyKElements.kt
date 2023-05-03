fun maximizeSum(nums: IntArray, k: Int): Int {

    val max = nums.maxOrNull()!!
    return (max + max + k - 1) * k / 2

}
