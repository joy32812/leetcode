/**
 * bitwise
 * sliding window
 */
fun smallestSubarrays(nums: IntArray): IntArray {

    val bits = IntArray(31)
    for (d in nums) {
        for (i in 0..30) {
            if (d and (1 shl i) != 0) {
                bits[i]++
            }
        }
    }

    val now = IntArray(31)
    fun add(d: Int) {
        for (i in 0..30) {
            if (d and (1 shl i) != 0) {
                now[i]++
            }
        }
    }

    fun remove(d: Int) {
        for (i in 0..30) {
            if (d and (1 shl i) != 0) {
                now[i]--
            }
        }
    }

    fun removeBit(d: Int) {
        for (i in 0..30) {
            if (d and (1 shl i) != 0) {
                bits[i]--
            }
        }
    }


    val ans = mutableListOf<Int>()
    fun isGood() = now.indices.all { i -> bits[i] == 0 || now[i] != 0 }

    var j = 0
    for (i in nums.indices) {

        while (j < nums.size && !isGood()) {
            add(nums[j])
            j++
            if (isGood()) break
        }
        j = maxOf(j, i + 1)
        ans += j - i
        remove(nums[i])
        removeBit(nums[i])
    }

    return ans.toIntArray()
}

