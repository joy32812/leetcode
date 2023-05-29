/**
 * union find.
 */
fun canTraverseAllPairs(nums: IntArray): Boolean {
    if (nums.size == 1) return true
    if (1 in nums) return false

    val M = nums.maxOrNull()!! + 10
    val numSet = nums.toSet()

    val fathers = IntArray(M) { it }
    fun getFather(x: Int): Int {
        if (fathers[x] != x) {
            fathers[x] = getFather(fathers[x])
        }
        return fathers[x]
    }

    val isPrime = BooleanArray(M) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2 until M) {
        if (isPrime[i]) {
            val found = mutableListOf<Int>()
            if (i in numSet) found += i

            for (j in i * 2 until M step i) {
                isPrime[j] = false
                if (j in numSet) found += j
            }

            if (found.size > 1) {
                val f1 = getFather(found[0])
                for (j in 1 until found.size) {
                    val f2 = getFather(found[j])
                    if (f1 != f2) {
                        fathers[f2] = f1
                    }
                }
            }
        }
    }


    return numSet.map { getFather(it) }.toSet().size == 1
}

fun main() {

}
