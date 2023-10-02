/**
 * brute-force. easy.
 */
fun minOperations(nums: List<Int>, k: Int): Int {
    val set = mutableSetOf<Int>()
    var cnt = 0
    for (i in nums.size - 1 downTo 0) {
        cnt ++

        if (nums[i] <= k) set += nums[i]
        if (set.size == k) return cnt
    }

    return -1
}
