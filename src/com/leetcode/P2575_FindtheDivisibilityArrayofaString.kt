fun divisibilityArray(word: String, m: Int): IntArray {
    var total = 0L
    val ans = mutableListOf<Int>()

    for (c in word) {
        total = total * 10 + (c - '0')
        total %= m

        ans += if (total == 0L) 1 else 0
    }

    return ans.toIntArray()
}
