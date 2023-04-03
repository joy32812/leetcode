fun primeSubOperation(nums: IntArray): Boolean {

    // generate a set with all the prime numbers <= 1000
    val primes = mutableSetOf<Int>()
    for (i in 2..1000) {
        var isPrime = true
        for (j in 2..i/2) {
            if (i % j == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) primes.add(i)
    }

    var last = -1
    for (i in nums.indices) {

        if (nums[i] <= last) return false

        var cur = nums[i]

        for (t in 2 until nums[i]) {
            if (t !in primes) continue

            val left = nums[i] - t

            if (left > last) {
                cur = minOf(cur, left)
            }
        }

        last = cur
    }

    return true
}
