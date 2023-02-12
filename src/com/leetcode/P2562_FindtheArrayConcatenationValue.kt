/**
 * easy
 */
fun findTheArrayConcVal(nums: IntArray): Long {

    var ans = 0L
    var i = 0
    var j = nums.size - 1

    while (i <= j) {
        if (i == j) {
            ans += nums[i]
            break
        }

        ans += ("${nums[i]}${nums[j]}").toLong()
        i ++
        j --
    }

    return ans
}