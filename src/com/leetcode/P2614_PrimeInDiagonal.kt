import java.math.BigInteger

// Check if a number is prime using BigInteger.isProbablePrime
fun diagonalPrime(nums: Array<IntArray>): Int {

    var ans = 0

    for (i in nums.indices) {
        for (j in nums[i].indices) {
            if (i == j || i + j == nums.size - 1) {
                if (BigInteger.valueOf(nums[i][j].toLong()).isProbablePrime(10)) {
                    ans = maxOf(ans, nums[i][j])
                }
            }
        }
    }

    return ans

}
