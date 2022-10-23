/**
 * sort and iterate.
 */
data class Node(val num: Int, val cost: Int)

fun minCost(nums: IntArray, cost: IntArray): Long {

    val nodes = nums.indices.map { i -> Node(nums[i], cost[i]) }.sortedBy { it.num }

    var ans = nodes.map { 1L * it.num * it.cost }.sum()

    var left = 0L
    var right = cost.map { it.toLong() }.sum()

    for (i in nodes.indices) {
        val diff = nodes[i].num - (if (i - 1 >= 0) nodes[i - 1].num else 0)

        val tmp = ans + left * diff - right * diff

        right -= nodes[i].cost
        left += nodes[i].cost

        ans = minOf(ans, tmp)
    }

    return ans
}

