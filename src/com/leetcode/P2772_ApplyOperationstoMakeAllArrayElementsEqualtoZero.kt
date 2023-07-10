/**
 * greedy + sliding window
 */
fun checkArray(nums: IntArray, k: Int): Boolean {
    val n = nums.size

    val subArray = Array(n) { 0 }
    var subTotal = 0

    for (i in 0 until n - k + 1) {
        if (i - k >= 0) subTotal -= subArray[i - k]

        if (nums[i] < subTotal) return false

        subArray[i] = nums[i] - subTotal
        subTotal = nums[i]
    }

    for (i in n - k + 1 until n) {
        if (i - k >= 0) subTotal -= subArray[i - k]
        if (nums[i] != subTotal) return false
    }

    return true
}

fun main() {
    // [2,2,3,1,1,0], 3
    println(checkArray(
        intArrayOf(2, 2, 3, 1, 1, 0),
        3
    ))


    // [31,60,97,71,53,46,63,50,91,82,40,79,96,100,55,55,57,39,50,98,72,37,27,55], 3
    println(checkArray(
        intArrayOf(31,60,97,71,53,46,63,50,91,82,40,79,96,100,55,55,57,39,50,98,72,37,27,55),
        3
    ))
}
