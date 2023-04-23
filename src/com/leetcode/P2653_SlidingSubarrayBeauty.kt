/**
 * Sliding window.
 */
fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {

    val N = 110
    val cnts = Array(N) { 0 }
    val A = nums.map { it + 50 }

    for (i in 0 until k) cnts[A[i]]++

    fun getXSmallest(): Int {
        var res = 0
        for (i in 0 until N) {
            res += cnts[i]
            if (res >= x) {
                return i
            }
        }
        return -1
    }

    val result = mutableListOf<Int>()

    for (i in 0..nums.size - k) {
        result.add(getXSmallest())
        cnts[A[i]]--
        if (i + k < nums.size) {
            cnts[A[i + k]]++
        }
    }

    return result.map { if (it - 50 < 0) it - 50 else 0 }.toIntArray()
}
