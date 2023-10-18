/**
 * dp.
 */
fun getWordsInLongestSubsequence(n: Int, words: Array<String>, groups: IntArray): List<String> {

    val dp = IntArray(n) { 1 }
    val from = IntArray(n) { -1 }

    fun isDisOne(s: String, t: String) = s.length == t.length && s.zip(t).count { it.first != it.second } == 1

    for (i in 1 until n) {
        var cnt = 0
        for (j in i - 1 downTo 0) {
            if (groups[j] == groups[i]) continue
            cnt ++

            if (cnt != 0) {
                if (isDisOne(words[i], words[j])) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1
                        from[i] = j
                    }
                }
            }

        }
    }

    val max = dp.maxOrNull() ?: 1
    val ans = mutableListOf<String>()
    var now = dp.indexOf(max)
    while (now != -1) {
        ans.add(words[now])
        now = from[now]
    }

    return ans.reversed()
}
