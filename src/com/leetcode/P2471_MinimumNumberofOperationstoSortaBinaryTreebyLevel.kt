/**
 * 1. get node value arrays for each level.
 * 2. use index array to count swap times.
 */
fun minimumOperations(root: TreeNode?): Int {

    val levelMap = mutableMapOf<Int, MutableList<Int>>()

    fun dfs(node: TreeNode?, level: Int) {
        if (node == null) return
        levelMap.getOrPut(level) { mutableListOf() }.add(node.`val`)
        dfs(node.left, level + 1)
        dfs(node.right, level + 1)
    }

    dfs(root, 0)

    fun getSwapCnt(nums: List<Int>): Int {
        val arr = nums.toTypedArray()
        val sorted = arr.sortedArray()
        val indMap = nums.mapIndexed { index, i -> i to index }.toMap().toMutableMap()

        var ans = 0
        for (i in arr.indices) {
            val d = sorted[i]
            if (arr[i] == sorted[i]) continue
            ans ++

            val ind = indMap[d]!!
            val tmp = arr[i]
            arr[i] = arr[ind]
            arr[ind] = tmp

            indMap[sorted[i]] = i
            indMap[arr[ind]] = ind
        }

        return ans
    }

    return levelMap.values.sumOf { getSwapCnt(it) }
}
