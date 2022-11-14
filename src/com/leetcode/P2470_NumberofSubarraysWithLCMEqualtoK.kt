/**
 * Brute force. O(n^2)
 */
fun subarrayLCM(nums: IntArray, k: Int): Int {

    fun gcd (a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }

    var ans = 0
    for (i in nums.indices) {

        var lcm = 1
        for (j in i until nums.size) {
            lcm = lcm * nums[j] / gcd(lcm, nums[j])
            if (lcm == k) ans ++
        }
    }


    return ans
}
