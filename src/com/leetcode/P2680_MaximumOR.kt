/**
 * iterate every num, shift it left k bits, and check the or of all nums
 */
fun maximumOr(nums: IntArray, k: Int): Long {
    val bits = IntArray(33)

    for (d in nums) {
        for (i in 0 until 32) {
            if (d and (1 shl i) != 0) {
                bits[i]++
            }
        }
    }

    var ans = 0L

    for (d in nums) {
        val tmp = bits.clone()

        for (i in 0 until 32) {
            if (d and (1 shl i) != 0) {
                tmp[i]--
            }
        }

        var now = 0L
        for (i in 0 until 32) {
            if (tmp[i] > 0) {
                now += (1L shl i)
            }
        }

        ans = maxOf(ans, now or (d.toLong() shl k))
    }

    return ans
}
