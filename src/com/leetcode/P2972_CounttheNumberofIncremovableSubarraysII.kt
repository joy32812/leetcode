/**
 * binary search.
 */
fun incremovableSubarrayCount2(nums: IntArray): Long {

    fun List<Int>.isStrictlyIncreasing(): Boolean {
        for (i in 1 until size) {
            if (this[i] <= this[i - 1]) {
                return false
            }
        }
        return true
    }
    if (nums.toList().isStrictlyIncreasing()) {
        val n = nums.size
        return 1L * n * (n + 1) / 2
    }

    fun List<Int>.toLeftStrictlyIncreasing(): List<Int> {
        val ans = mutableListOf<Int>()
        var max = -1
        for (i in this) {
            if (i > max) {
                ans.add(i)
                max = i
            } else break
        }
        return ans
    }

    fun List<Int>.toRightStrictlyIncreasing(): List<Int> {
        val ans = mutableListOf<Int>()
        var max = Int.MAX_VALUE
        for (i in this.reversed()) {
            if (i < max) {
                ans.add(i)
                max = i
            } else break
        }
        return ans.reversed()
    }


    val left = nums.toList().toLeftStrictlyIncreasing()
    val right = nums.toList().toRightStrictlyIncreasing()

    var ans = 1L + left.size + right.size

    for (x in left) {
        if (x >= right.last()) {
            continue
        }

        // binary search to find the index of first element greater than x
        var l = 0
        var r = right.size - 1
        while (l < r) {
            val mid = l + (r - l) / 2
            if (right[mid] <= x) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        ans += right.size - l
    }

    return ans
}

fun main() {
    // 6, 7, 5
    println(incremovableSubarrayCount2(intArrayOf(6, 7, 5)))

    // 8,7,6,6
    println(incremovableSubarrayCount2(intArrayOf(8, 7, 6, 6)))

    // Input: nums = [1,2,3,4]
    println(incremovableSubarrayCount2(intArrayOf(1, 2, 3, 4)))

    // Input: nums = [6,5,7,8]
    println(incremovableSubarrayCount2(intArrayOf(6, 5, 7, 8)))
}
