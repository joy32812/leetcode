fun closetTarget(words: Array<String>, target: String, startIndex: Int): Int {

    var ans = -1

    for (k in words.indices) {
        val i = (startIndex + k) % words.size

        if (words[i] == target) {
            val tmp = minOf(Math.abs(i - startIndex), words.size - Math.abs(i - startIndex))
            if (ans == -1 || tmp < ans) {
                ans = tmp
            }
        }
    }


    return ans
}
