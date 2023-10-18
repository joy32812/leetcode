/**
 * bit count.
 */
fun maxSum(nums: List<Int>, k: Int): Int {

    val bitCnt = IntArray(32)
    for (num in nums) {
        for (i in 0 until 32) {
            if (num and (1 shl i) != 0) {
                bitCnt[i]++
            }
        }
    }

    val mod = 1_000_000_007
    var ans = 0L

    repeat(k) {
        var tmp = 0
        for (i in 0 until 32) {
            if (bitCnt[i] > 0) {
                tmp = tmp or (1 shl i)
                bitCnt[i] --
            }
        }

        ans += 1L * tmp * tmp
        ans %= mod
    }

    return ans.toInt()
}

fun main() {

    // nums = [2,6,5,8], k = 2
    println(
        maxSum(listOf(2,6,5,8), 2)
    )
}
