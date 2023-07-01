fun maximumNumberOfStringPairs(words: Array<String>): Int {

    val n = words.size
    val used = BooleanArray(n)
    var ans = 0

    for (i in words.indices) {
        if (used[i]) continue

        used[i] = true

        for (j in i + 1 until n) {
            if (used[j]) continue

            if (words[i].reversed() == words[j]) {
                ans ++
                used[j] = true
                break
            }
        }

    }
    return ans

}
