fun minNumber(nums1: IntArray, nums2: IntArray): Int {

    for (i in 1..9) {
        if (i in nums1 && i in nums2) return i
    }

    return listOf(
        nums1.minOrNull() ?: 0,
        nums2.minOrNull() ?: 0
    ).sorted().joinToString("").toInt()

}
