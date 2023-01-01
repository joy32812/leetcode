/**
 * Find prime factors of a number
 */
fun distinctPrimeFactors(nums: IntArray): Int {

    fun getPrimeFactors(num: Int): Set<Int> {

        var n = num
        val factors = mutableSetOf<Int>()
        var i = 2
        while (i * i <= n) {
            while (n % i == 0) {
                factors.add(i)
                n /= i
            }
            i++
        }
        if (n > 1) factors.add(n)
        return factors
    }

    return nums.flatMap { getPrimeFactors(it) }.toSet().size

}
