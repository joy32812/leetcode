/**
 * Mod first. Then concatenate the array by itself. Then find the min size subarray.
 */
fun minSizeSubarray(nums: IntArray, target: Int): Int {
    val totalSum = nums.sumOf { it.toLong() }
    val newTarget = target % totalSum
    val cnt = target / totalSum

    if (newTarget == 0L) return (cnt * nums.size).toInt()

    val arr = nums + nums
    val sum2Index = mutableMapOf<Long, Int>()
    sum2Index[0L] = -1

    var ans = Int.MAX_VALUE
    var sum = 0L
    for (i in arr.indices) {
        sum += arr[i]

        if (sum - newTarget in sum2Index) {
            ans = minOf(ans, i - sum2Index[sum - newTarget]!!)
        }
        sum2Index[sum] = i
    }

    return if (ans == Int.MAX_VALUE) -1 else (ans + cnt * nums.size).toInt()
}

