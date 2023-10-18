/**
 * prefix + suffix product.
 */
data class IndexWithValue(val i: Int, val j: Int, val v: Int)
fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {

    val mod = 12345
    val nums = mutableListOf<IndexWithValue>()
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            nums += IndexWithValue(i, j, grid[i][j])
        }
    }

    val left = LongArray(nums.size) { 1L }
    var product = 1L
    for (i in nums.indices) {
        product = (product * nums[i].v) % mod
        left[i] = product
    }

    val right = LongArray(nums.size) { 1L }
    product = 1L
    for (i in nums.indices.reversed()) {
        product = (product * nums[i].v) % mod
        right[i] = product
    }

    val ans = Array(grid.size) { IntArray(grid[0].size) }
    for (i in nums.indices) {
        val ll = if (i - 1 < 0) 1L else left[i - 1]
        val rr = if (i + 1 >= nums.size) 1L else right[i + 1]

        ans[nums[i].i][nums[i].j] = ((ll * rr) % mod).toInt()
    }

    return ans
}
