fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {

    fun getLevelSumMap(root: TreeNode?, level: Int, map: MutableMap<Int, Long>): MutableMap<Int, Long> {
        if (root == null) {
            return map
        }

        map[level] = map.getOrDefault(level, 0) + root.`val`

        getLevelSumMap(root.left, level + 1, map)
        getLevelSumMap(root.right, level + 1, map)

        return map
    }

    val map = getLevelSumMap(root, 0, mutableMapOf())

    if (k > map.size) return -1

    return map.values.sortedDescending()[k - 1]
}
