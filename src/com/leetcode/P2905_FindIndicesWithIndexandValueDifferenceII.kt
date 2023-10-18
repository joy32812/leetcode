/**
 * find max and min from the left.
 */
fun findIndices2(nums: IntArray, indexDifference: Int, valueDifference: Int): IntArray {
    val n = nums.size
    val maxFromLeft = IntArray(n)
    val maxFromLeftIndex = IntArray(n)

    val minFromLeft = IntArray(n)
    val minFromLeftIndex = IntArray(n)

    maxFromLeft[0] = nums[0]
    minFromLeft[0] = nums[0]
    for (i in 1 until n) {
        maxFromLeftIndex[i] = i
        maxFromLeft[i] = nums[i]
        if (maxFromLeft[i] < maxFromLeft[i - 1]) {
            maxFromLeft[i] = maxFromLeft[i - 1]
            maxFromLeftIndex[i] = maxFromLeftIndex[i - 1]
        }

        minFromLeftIndex[i] = i
        minFromLeft[i] = nums[i]
        if (minFromLeft[i] > minFromLeft[i - 1]) {
            minFromLeft[i] = minFromLeft[i - 1]
            minFromLeftIndex[i] = minFromLeftIndex[i - 1]
        }
    }

    for (j in indexDifference until n) {
        val i = j - indexDifference
        val max = maxFromLeft[i]
        val min = minFromLeft[i]

        if (Math.abs(max - nums[j]) >= valueDifference) {
            return intArrayOf(maxFromLeftIndex[i], j)
        }
        if (Math.abs(min - nums[j]) >= valueDifference) {
            return intArrayOf(minFromLeftIndex[i], j)
        }
    }

    return intArrayOf(-1, -1)
}

fun main() {
    // [5,12], 0, 10
    println(findIndices2(intArrayOf(5, 12), 0, 10).toList())
}
