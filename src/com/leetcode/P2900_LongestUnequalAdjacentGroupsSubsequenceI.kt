/**
 * greedy algorithm.
 */
fun getWordsInLongestSubsequence1(n: Int, words: Array<String>, groups: IntArray): List<String> {

    val ans = mutableListOf(words[0])
    for (i in 1 until n) {
        if (groups[i] != groups[i - 1]) ans += words[i]
    }

    return ans
}
