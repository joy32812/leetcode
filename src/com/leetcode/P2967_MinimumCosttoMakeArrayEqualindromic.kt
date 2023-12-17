/**
 * median and nearest palindromic.
 */
fun minimumCost(nums: IntArray): Long {
    nums.sort()

    val middles = if (nums.size % 2 == 1) {
        listOf(nums[nums.size / 2])
    } else {
        listOf(nums[nums.size / 2 - 1], nums[nums.size / 2])
    }

    fun Int.isPalindromic(): Boolean {
        val s = this.toString()
        return s == s.reversed()
    }

    fun getFirstLargerOrEqualPalindromicNumber(x: Int): Int {
        var i = x
        while (true) {
            if (i.isPalindromic()) return i
            i ++
        }
    }

    fun getFirstSmallerOrEqualPalindromicNumber(x: Int): Int {
        var i = x
        while (true) {
            if (i.isPalindromic()) return i
            i --
        }
    }

    val possibles = middles.flatMap { m ->
        val larger = getFirstLargerOrEqualPalindromicNumber(m)
        val smaller = getFirstSmallerOrEqualPalindromicNumber(m)
        listOf(larger, smaller)
    }

    return possibles.minOf { nums.sumOf { n -> 0L + Math.abs(n - it) } }
}
