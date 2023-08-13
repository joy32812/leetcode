import java.util.*

/**
 * Number of subarrays with maximum score.
 * Use stack to get nearest left and right index.
 * left: first index j that nums[j] >= current
 * right: first index j that nums[j] > current
 */
fun maximumScore(nums: List<Int>, k: Int): Int {

    fun getPrimesLessThanX(x: Int): List<Int> {
        val primes = mutableListOf<Int>()
        val isPrime = BooleanArray(x) { true }
        for (i in 2 until x) {
            if (isPrime[i]) {
                primes += i
                if (1L * i * i >= x) continue
                for (j in i * i until x step i) {
                    isPrime[j] = false
                }
            }
        }
        return primes
    }
    val primes = getPrimesLessThanX(100_010)

    fun Int.toPrimeCount(): Int {
        var ans = 0
        var num = this
        for (prime in primes) {
            if (1L * prime * prime > num) break
            if (num % prime == 0) {
                ans++
                while (num % prime == 0) {
                    num /= prime
                }
            }
        }
        if (num > 1) ans++
        return ans
    }

    val numToPrimeCount = nums.toSet().associateWith { it.toPrimeCount() }

    val n = nums.size

    // the index of the first element >= nums[i]
    val left = Array(n) { -1 }
    val stack = Stack<Int>()
    for (i in 0 until n) {
        while (stack.isNotEmpty() && numToPrimeCount[nums[stack.peek()]]!! < numToPrimeCount[nums[i]]!!) {
            stack.pop()
        }
        left[i] = if (stack.isEmpty()) -1 else stack.peek()
        stack.push(i)
    }

    // the index of the first element > nums[i]
    val right = Array(n) { n }
    stack.clear()
    for (i in n - 1 downTo 0) {
        while (stack.isNotEmpty() && numToPrimeCount[nums[stack.peek()]]!! <= numToPrimeCount[nums[i]]!!) {
            stack.pop()
        }
        right[i] = if (stack.isEmpty()) n else stack.peek()
        stack.push(i)
    }

    val numsDesc = nums.withIndex().map { (i, v) ->  Pair(i, v) }.sortedByDescending { it.second }

    val mod = 1_000_000_007L
    fun power(x: Int, y: Int): Long {
        var ans = 1L
        var base = x.toLong()
        var exp = y
        while (exp > 0) {
            if (exp % 2 == 1) {
                ans = (ans * base) % mod
            }
            base = (base * base) % mod
            exp /= 2
        }
        return ans
    }

    var ans = 1L
    var tk = k
    for ((i, v) in numsDesc) {
        val ll = i - left[i]
        val rr = right[i] - i
        val cnt = 1L * ll * rr

        if (tk <= cnt) {
            ans *= power(v, tk)
            break
        } else {
            ans *= power(v, cnt.toInt())
            tk -= cnt.toInt()
        }

        ans %= mod
    }

    return (ans % mod).toInt()
}
