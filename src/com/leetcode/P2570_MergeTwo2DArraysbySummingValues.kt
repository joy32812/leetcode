/**
 * associate.
 */
fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {

    val map1 = nums1.associate { it[0] to it[1] }
    val map2 = nums2.associate { it[0] to it[1] }

    val keys = (map1.keys + map2.keys).distinct()

    return keys.map { key ->
        val value1 = map1[key] ?: 0
        val value2 = map2[key] ?: 0
        intArrayOf(key, value1 + value2)
    }.sortedBy { it[0] }.toTypedArray()

}
