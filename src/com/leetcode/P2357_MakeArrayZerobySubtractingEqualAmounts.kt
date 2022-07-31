/**
 * sort and greedy.
 */
fun minimumOperations(nums: IntArray): Int {
    nums.sort()

    var tmp = 0
    var count = 0
    for (d in nums) {
        if (tmp < d) {
            tmp = d
            count++
        }
    }

    return count
}
