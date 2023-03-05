fun findValidSplit(nums: IntArray): Int {

    fun getPrimesInX(x: Int): List<Int> {
        var i = 2
        var n = x
        val primes = mutableListOf<Int>()
        while (i * i <= n) {
            if (n % i == 0) {
                primes.add(i)
                while (n % i == 0) {
                    n /= i
                }
            }
            i++
        }
        if (n > 1) {
            primes.add(n)
        }
        return primes
    }

    val ps = Array(nums.size) { getPrimesInX(nums[it]) }

    val maxIndexs = mutableMapOf<Int, Int>()
    for (i in ps.indices) {
        val primes = ps[i]

        for (p in primes) {
            maxIndexs[p] = i
        }
    }

    var maxIndex = 0
    for (i in 0 until ps.size - 1) {
        val primes = ps[i]

        for (p in primes) {
            maxIndex = maxOf(maxIndex, maxIndexs[p]!!)
        }

        if (maxIndex == i) {
            return i
        }
    }

    return -1
}
