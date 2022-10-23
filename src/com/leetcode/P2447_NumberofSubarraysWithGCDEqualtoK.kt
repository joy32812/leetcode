/**
 * brute force.
 */
fun subarrayGCD(nums: IntArray, k: Int): Int {

    fun gcd(x: Int, y: Int): Int {
        if (y == 0) return x
        return gcd(y, x % y)
    }

    var cnt = 0

    for (i in nums.indices) {
        var g = nums[i]
        if (g == k) cnt++
        for (j in i + 1 until nums.size) {
            g = gcd(g, nums[j])
            if (g == k) cnt++
        }
    }

    return cnt
}
