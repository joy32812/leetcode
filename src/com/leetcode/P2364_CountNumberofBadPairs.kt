/**
 * j - i != nums[j] - nums[i] -->  nums[i] - i != nums[j] - j
 *
 */
fun countBadPairs(nums: IntArray): Long {

    val ints = nums.mapIndexed { i, d -> d - i }

    val cntMap = mutableMapOf<Int, Int>()
    var total = 0L
    for (i in ints.indices) {
        val d = ints[i]
        total += i - (cntMap[d] ?: 0)
        cntMap[d] = (cntMap[d] ?: 0) + 1
    }

    return total
}
