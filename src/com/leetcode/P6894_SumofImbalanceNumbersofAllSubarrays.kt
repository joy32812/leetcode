import java.util.*

fun sumImbalanceNumbers(nums: IntArray): Int {
    var ans = 0

    for (i in nums.indices) {
        val treeSet = TreeSet<Int>()
        var prev = 0
        for (j in i until nums.size) {
            val x = nums[j]

            if (x in treeSet) {
                ans += prev
                continue
            }

            val floor = treeSet.floor(x)
            val ceil = treeSet.ceiling(x)
            if (floor != null) {
                if (ceil != null) {
                    if (ceil - floor > 1 && x - floor <= 1) prev --
                } else {
                    if (x - floor > 1) prev ++
                }
            }

            if (ceil != null && ceil - x > 1) {
                prev ++
            }

            ans += prev
            treeSet += x
        }
    }

    return ans
}

