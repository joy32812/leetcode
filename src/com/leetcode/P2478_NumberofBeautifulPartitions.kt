/**
 * dp.
 * Use prefix sum to optimize.
 */
fun beautifulPartitions(s: String, k: Int, minLength: Int): Int {
    fun isPrime(x: Int) = x in setOf(2, 3, 5, 7)

    if (!isPrime(s[0] - '0')) return 0

    val mod = 1000000007
    var dp = Array(s.length) { 0 }
    for (i in s.indices) {
        if (i + 1 < minLength) continue
        if (isPrime((s[i] - '0'))) continue
        if (i + 1 == s.length || isPrime((s[i + 1] - '0'))) {
            dp[i] = 1
        }
    }

    for (z in 2 .. k) {

        val prefixSum = Array(s.length) { 0 }
        for (i in s.indices) {
            prefixSum[i] = dp[i]
            if (i > 0) prefixSum[i] = (prefixSum[i] + prefixSum[i - 1]) % mod
        }

        val tmpDp = Array(s.length) { 0 }
        for (i in s.indices) {
            if (isPrime((s[i] - '0'))) continue

            val l = minLength * (z - 1) - 1
            val r = i - minLength

            if (l > r) continue

            val sum = if (l == 0) prefixSum[r] else (prefixSum[r] - prefixSum[l - 1] + mod) % mod
            if (i + 1 == s.length || isPrime((s[i + 1] - '0'))) {
                tmpDp[i] = sum
            }
        }

        dp = tmpDp
    }

    return dp[s.length - 1]
}
