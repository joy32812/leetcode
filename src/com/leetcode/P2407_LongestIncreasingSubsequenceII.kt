/**
 * Segment tree.
 */
data class Seg(
    val l: Int,
    val r: Int,
    var max: Int,
    val left: Seg?,
    val right: Seg?
)

fun lengthOfLIS(nums: IntArray, k: Int): Int {

    val MAX = 1_00_000 + 10

    fun insert(root: Seg, l: Int, r: Int, value: Int) {
        if (l <= root.l && root.r <= r) {
            root.max = maxOf(root.max, value)
            return
        }

        val mid = (root.l + root.r) / 2
        if (r <= mid) {
            insert(root.left!!, l, r, value)
        } else if (l > mid) {
            insert(root.right!!, l, r, value)
        } else {
            insert(root.left!!, l, mid, value)
            insert(root.right!!, mid + 1, r, value)
        }
        root.max = maxOf(root.left?.max ?: 0, root.right?.max ?: 0)
    }

    fun build(l: Int, r: Int): Seg {
        if (l == r) {
            return Seg(l, r, 0, null, null)
        }

        val mid = (l + r) / 2
        return Seg(l, r, 0, build(l, mid), build(mid + 1, r))
    }

    fun get(root: Seg, l: Int, r: Int): Int {
        if (l <= root.l && root.r <= r) {
            return root.max
        }

        val mid = (root.l + root.r) / 2
        if (r <= mid) {
            return get(root.left!!, l, r)
        } else if (l > mid) {
            return get(root.right!!, l, r)
        } else {
            return maxOf(get(root.left!!, l, mid), get(root.right!!, mid + 1, r))
        }
    }

    val root = build(0, MAX)

    var ans = 0
    for (d in nums) {
        if (d == 1) {
            ans = maxOf(ans, 1)
            insert(root, 1, 1, 1)
            continue
        }

        val l = maxOf(1, d - k)
        val r = d - 1

        val max = get(root, l, r)
        ans = maxOf(ans, max + 1)

        insert(root, d, d, max + 1)
    }

    return ans
}
