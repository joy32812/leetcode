/**
 * XOR.
 */
fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {

    fun okay(x: Int): Boolean {
        val aa = nums1.map { if ((it and (1 shl x)) != 0) 1 else 0 }
        val bb = nums2.map { if ((it and (1 shl x)) != 0) 1 else 0 }
        val c = bb.sum() % 2

        return aa.map {
            val z = if (bb.size % 2 == 0) 0 else it
            z xor c
        }.sum() % 2 == 1
    }

    return (0 until 30).map { if (okay(it)) 1 shl it else 0 }.sum()
}

