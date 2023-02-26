/**
 * greedy from the middle.
 */
fun maxNumOfMarkedIndices(nums: IntArray): Int {
    nums.sort()

    var ans = 0

    var l = nums.size / 2 - 1
    var r = nums.size - 1

    while (l >= 0 && r >= nums.size / 2) {
        if (nums[l] * 2 <= nums[r]) {
            ans++
            l--
            r--
        } else {
            l--
        }
    }


    return ans * 2
}
