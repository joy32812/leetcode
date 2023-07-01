fun countBeautifulPairs(nums: IntArray): Int {

    var ans = 0

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {

            val x = "${nums[i]}".first() - '0'
            val y = "${nums[j]}".last() - '0'

            if (gcd(x, y) == 1) ans ++
        }
    }

    return ans
}
