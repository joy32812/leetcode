/**
 * Greedy.
 */
fun minOperations(nums: IntArray): Int {

    val cntMap = nums.groupBy { it }.mapValues { it.value.size }

    if (1 in cntMap.values) return -1

    return cntMap.values.sumOf { it / 3 + (if (it % 3 != 0) 1 else 0) }

}
