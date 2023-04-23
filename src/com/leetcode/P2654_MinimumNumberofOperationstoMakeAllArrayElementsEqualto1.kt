/**
 * find min step to make the One.
 */
fun minOperations(nums: IntArray): Int {

    fun gcd(x: Int, y: Int): Int {
        if (y == 0) return x
        return gcd(y, x % y)
    }

    fun getMinStepFrom(i: Int): Int {
        if (nums[i] == 1) return 0

        var now = nums[i]
        for (j in i + 1 until nums.size) {
            now = gcd(now, nums[j])
            if (now == 1) {
                return j - i
            }
        }

        return Int.MAX_VALUE
    }

    val minStep = nums.indices.map { getMinStepFrom(it) }.minOrNull()!!

    val nonOneCnt = nums.count { it != 1 }

    if (minStep == Int.MAX_VALUE) return -1
    if (minStep == 0) return nonOneCnt

    return minStep + nonOneCnt - 1
}

fun main() {
    // Input: nums = [2,6,3,4]
    println(minOperations(intArrayOf(2, 6, 3, 4)))
}
