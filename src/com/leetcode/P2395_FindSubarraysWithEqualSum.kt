/**
 * zipWithNext
 */
fun findSubarrays(nums: IntArray): Boolean {

    val aa = nums.toList().zipWithNext().map { it.first + it.second }
    return aa.toSet().size != aa.size

}
