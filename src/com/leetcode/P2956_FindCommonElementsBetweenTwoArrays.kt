/**
 * brute-force
 */
fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
    val cnt1 = nums1.count { it in nums2 }
    val cnt2 = nums2.count { it in nums1 }

    return listOf(cnt1, cnt2).toIntArray()
}
