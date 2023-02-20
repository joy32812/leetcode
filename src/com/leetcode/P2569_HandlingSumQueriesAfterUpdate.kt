

private class SegNode(var l: Int, var r: Int) {
    var left: SegNode? = null
    var right: SegNode? = null
    var flip = 0
    var sum = 0L
}

/**
 * segment tree.
 */
fun handleQuery(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): LongArray {

    fun build(l: Int, r: Int): SegNode {
        val node = SegNode(l, r)
        if (l == r) {
            node.sum = nums1[l].toLong()
            return node
        }

        val mid = (l + r) / 2
        node.left = build(l, mid)
        node.right = build(mid + 1, r)
        node.sum = node.left!!.sum + node.right!!.sum
        return node
    }


    fun flip(node: SegNode, l: Int, r: Int) {
        if (node.l == l && node.r == r) {
            node.flip = 1 - node.flip
            node.sum = (r - l + 1) - node.sum
            return
        }

        if (node.flip == 1) {
            flip(node.left!!, node.l, (node.l + node.r) / 2)
            flip(node.right!!, (node.l + node.r) / 2 + 1, node.r)
            node.flip = 0
        }

        val mid = (node.l + node.r) / 2
        if (r <= mid) {
            flip(node.left!!, l, r)
        } else if (l > mid) {
            flip(node.right!!, l, r)
        } else {
            flip(node.left!!, l, mid)
            flip(node.right!!, mid + 1, r)
        }

        node.sum = node.left!!.sum + node.right!!.sum
    }

    val root = build(0, nums1.size - 1)

    var sum2 = nums2.map { it.toLong() }.sum()

    return queries.mapNotNull { (type, l, r) ->
        when (type) {
            1 -> {
                flip(root, l, r)
                null
            }
            2 -> {
                sum2 += root.sum * l
                null
            }
            else -> {
                sum2
            }
        }
    }.toLongArray()


}
