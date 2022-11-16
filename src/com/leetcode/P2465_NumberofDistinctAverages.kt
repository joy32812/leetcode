/**
 * Sort.
 */
fun distinctAverages(nums: IntArray): Int {
    nums.sort()

    var i = 0
    var j = nums.size - 1

    val set = mutableSetOf<Int>()

    while (i <= j) {
        val a = nums[i]
        val b = nums[j]

        set += a + b
        i ++
        j --
    }

    return set.size

}
