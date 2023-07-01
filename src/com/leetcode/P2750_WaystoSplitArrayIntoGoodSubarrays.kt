fun numberOfGoodSubarraySplits(nums: IntArray): Int {

    val mod = 1_000_000_007

    val ones = nums
        .withIndex()
        .filter { it.value == 1 }
        .map { it.index }

    if (ones.isEmpty()) return 0

    var ans = 1L
    for (i in 1 until ones.size) {
        ans = ans * (ones[i] - ones[i - 1]) % mod
    }

    return ans.toInt()

}

