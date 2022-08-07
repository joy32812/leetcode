/**
 * brute force solution
 */
fun arithmeticTriplets(nums: IntArray, diff: Int): Int {

    var count = 0
    for (i in 0 until nums.size - 2) {
        for (j in i + 1 until nums.size - 1) {
            if (nums[j] - nums[i] != diff) continue
            for (k in j + 1 until nums.size) {
                if (nums[k] - nums[j] == diff) {
                    count++
                }
            }
        }
    }
    return count

}
