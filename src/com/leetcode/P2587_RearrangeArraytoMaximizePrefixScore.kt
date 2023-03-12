/**
 * Greedy. sort.
 */
fun maxScore(nums: IntArray): Int {

    nums.sortDescending()

    var sum = 0L
    var cnt = 0
    for (d in nums) {
        sum += d

        if (sum > 0) cnt ++
    }

    return cnt
}
