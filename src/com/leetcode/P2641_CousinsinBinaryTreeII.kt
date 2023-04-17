fun replaceValueInTree(root: TreeNode?): TreeNode? {

    val levelSum = mutableListOf<Int>()

    fun getLevelSum(node: TreeNode?, level: Int) {
        if (node == null) return
        if (levelSum.size <= level) levelSum.add(0)
        levelSum[level] += node.`val`
        getLevelSum(node.left, level + 1)
        getLevelSum(node.right, level + 1)
    }

    getLevelSum(root, 0)

    fun work(node: TreeNode, level: Int, parentSum: Int): TreeNode {
        node.`val` = levelSum[level] - parentSum

        val newSum = (node.left?.`val` ?: 0) + (node.right?.`val` ?: 0)

        if (node.left != null) work(node.left!!, level + 1, newSum)
        if (node.right != null) work(node.right!!, level + 1, newSum)

        return node
    }

    return work(root!!, 0, root!!.`val`)

}
