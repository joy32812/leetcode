/**
 * binary search
 */
fun minimizeMax(nums: IntArray, p: Int): Int {
    nums.sort()

    var l = 0
    var r = nums.last() - nums.first() + 1

    fun check(m: Int): Boolean {

        var cnt = 0
        var i = 0
        while (i < nums.size - 1) {
            if (nums[i + 1] - nums[i] <= m) {
                cnt ++
                i ++
            }

            i++
        }

        return cnt >= p
    }

    while (l < r) {
        val mid = (l + r) / 2
        if (check(mid)) {
            r = mid
        } else {
            l = mid + 1
        }
    }

    return l

}
