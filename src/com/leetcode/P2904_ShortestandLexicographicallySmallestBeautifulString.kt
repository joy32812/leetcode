fun shortestBeautifulSubstring(s: String, k: Int): String {
    val ones = s.withIndex().filter { it.value == '1' }
    var ans = s + s

    for (i in ones.indices) {
        val j = i + k - 1
        if (j >= ones.size) break

        val tmp = s.substring(ones[i].index..ones[j].index)
        if ((tmp.length < ans.length) || (tmp.length == ans.length && tmp < ans)) ans = tmp
    }

    if (ans.length > s.length) return ""
    return ans
}
