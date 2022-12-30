/**
 * Binary Search.
 */
fun maximumTastiness(price: IntArray, k: Int): Int {
    price.sort()

    var l = 0
    var r = 1_000_000_000

    fun okay(m: Int): Boolean {

        var last = price[0]
        var count = 1

        for (i in 1 until price.size) {
            if (price[i] - last >= m) {
                last = price[i]
                count++
            }
        }


        return count >= k
    }

    while (l < r) {
        val m = (l + r) / 2

        if (!okay(m)) r = m
        else l = m + 1
    }

    return l - 1
}
