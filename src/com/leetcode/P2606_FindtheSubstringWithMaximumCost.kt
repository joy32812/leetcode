fun maximumCostSubstring(s: String, chars: String, vals: IntArray): Int {

    val c2d = mutableMapOf<Char, Int>()
    for (i in chars.indices) {
        c2d[chars[i]] = vals[i]
    }

    fun getV(c: Char) = c2d[c] ?: (c - 'a' + 1)

    var ans = 0

    var last = 0

    for (c in s) {
        last += getV(c)

        ans = maxOf(ans, last)

        if (last < 0) last = 0
    }

    return ans
}
