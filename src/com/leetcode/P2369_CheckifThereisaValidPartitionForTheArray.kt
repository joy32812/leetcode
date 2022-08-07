/**
 * simple dp
 */
fun validPartition(nums: IntArray): Boolean {

    val dp = BooleanArray(nums.size)


    fun checkTwo(p: Int) {
        if (nums[p] == nums[p - 1] && (p - 2 < 0 || dp[p - 2])) {
            dp[p] = true
        }
    }

    fun checkThree(p: Int) {
        if ((p - 3 == -1 || (p - 3 >= 0 && dp[p - 3])) && nums[p - 2] == nums[p - 1] && nums[p - 1] == nums[p]) {
            dp[p] = true
        }
    }

    fun checkThreeCon(p: Int) {
        if ((p - 3 == -1 || (p - 3 >= 0 && dp[p - 3])) && nums[p - 2] + 1 == nums[p - 1] && nums[p - 1] + 1== nums[p]) {
            dp[p] = true
        }
    }

    for (i in 1 until nums.size) {
        checkTwo(i)
        checkThree(i)
        checkThreeCon(i)
    }

    return dp[nums.size - 1]
}

fun main() {
    println(validPartition(intArrayOf(4,4,4,5,6)))
}
