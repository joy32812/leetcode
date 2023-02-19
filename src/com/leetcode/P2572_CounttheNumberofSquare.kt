/**
 * state dp.
 */
fun squareFreeSubsets(nums: IntArray): Int {

    val mod = 1000000007

    val primes = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)

    val dp = Array(1 shl primes.size) { 0L }

    for (i in nums.indices) {

        if (primes.any { nums[i] % (it * it) == 0 }) {
            continue
        }

//        val mySet = primes.filter { nums[i] % it == 0 }.toSet()
        val indexSet = primes
            .withIndex()
            .filter { nums[i] % it.value == 0 }
            .map { it.index }
            .toSet()

        val v = indexSet.map { 1 shl it }.sum()

        for (j in 0 until (1 shl primes.size)) {

            if (indexSet.any { j and (1 shl it) != 0 }) {
                continue
            }

            dp[j or v] = (dp[j or v] + dp[j]) % mod
        }

        dp[v] = (dp[v] + 1) % mod
    }

    return (dp.sum()%mod).toInt()
}
