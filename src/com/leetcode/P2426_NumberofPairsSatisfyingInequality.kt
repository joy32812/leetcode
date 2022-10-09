/**
 * Binary indexed tree.
 */
fun numberOfPairs(nums1: IntArray, nums2: IntArray, diff: Int): Long {

    val BASE = 1_000_00
    val BIT = Array(200001) { 0 }

    fun add(x: Int) {
        var i = x + BASE
        while (i < BIT.size) {
            BIT[i]++
            i += i and -i
        }
    }

    fun sum(x: Int): Int {
        var i = x + BASE
        var res = 0
        while (i > 0) {
            res += BIT[i]
            i -= i and -i
        }
        return res
    }

    var ans = 0L
    for (i in nums1.indices) {
        val d = nums1[i] - nums2[i]
        ans += sum(d)
        add(d - diff)
    }

    return ans
}
