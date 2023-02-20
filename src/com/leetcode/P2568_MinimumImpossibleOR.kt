/**
 * power of 2.
 */
fun minImpossibleOR(nums: IntArray): Int {
    val numSet = nums.toSet()

    for (i in 0..30) {
        if ((1 shl i) !in numSet) {
            return 1 shl i
        }
    }

    return -1

}
