/**
 * brute force solution.
 */
fun countDistinctIntegers(nums: IntArray): Int {
    return (nums.toSet() + nums.map { it.toString().reversed().toInt() }.toSet()).size
}
