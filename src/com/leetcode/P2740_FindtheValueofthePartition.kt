import kotlin.math.abs

/**
 * Sort.
 */
fun findValueOfPartition(nums: IntArray): Int {

  return nums.sorted().zipWithNext().minOf { abs(it.first - it.second) }

}