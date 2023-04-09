fun distance(nums: IntArray): LongArray {

    val ans = LongArray(nums.size) { 0L }

    fun onePass(isReversed: Boolean = false) {
        val cntMap = mutableMapOf<Int, Int>()
        val sumMap = mutableMapOf<Int, Long>()

        val indices = if (isReversed) nums.indices.reversed() else nums.indices

        for (i in indices) {
            val cnt = cntMap[nums[i]] ?: 0
            val sum = sumMap[nums[i]] ?: 0L

            ans[i] += Math.abs(1L * i * cnt - sum)

            cntMap[nums[i]] = cnt + 1
            sumMap[nums[i]] = sum + i
        }
    }

    onePass(isReversed = false)
    onePass(isReversed = true)

    return ans
}
