/**
 * Math problem.
 */
fun sumOfPower(nums: IntArray): Int {
    val MOD = 1_000_000_007

    nums.sortDescending()

    var ans = 0L
    var prev = 0L

    for (i in nums.indices.reversed()) {

        val t1 = (1L * nums[i] * nums[i]) % MOD
        val t2 = (t1 * (prev + nums[i])) % MOD

        ans = (ans + t2) % MOD

        prev = prev * 2 + nums[i]
        prev %= MOD

    }


    return ans.toInt()

}

fun main() {
    println(sumOfPower(intArrayOf(1, 2, 4)))
}
