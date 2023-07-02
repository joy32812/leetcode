fun findPrimePairs(n: Int): List<List<Int>> {

    val primes = BooleanArray(n + 1) { true }
    primes[0] = false
    primes[1] = false
    for (i in 2 .. n) {
        if (primes[i]) {
            for (j in i + i .. n step i) {
                primes[j] = false
            }
        }
    }


    val ans = mutableListOf<List<Int>>()
    for (i in 2 .. n) {
        val j = n - i
        if (i > j) break

        if (primes[i] && primes[j]) {
            ans += listOf(i, j)
        }
    }

    return ans
}
