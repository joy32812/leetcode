fun findPrefixScore(nums: IntArray): LongArray {
    val n = nums.size
    val conArray = Array(n) { 0L }

    var max = 0L
    for (i in nums.indices) {
        max = maxOf(max, nums[i].toLong())
        conArray[i] = nums[i] + max
    }

    val prefixOfConArray = LongArray(n)
    prefixOfConArray[0] = conArray[0]
    for (i in 1 until n) {
        prefixOfConArray[i] = prefixOfConArray[i - 1] + conArray[i]
    }

    return prefixOfConArray
}
