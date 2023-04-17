fun addMinimum(word: String): Int {

    var lastChar = 'c'
    var ans = 0

    for (ch in word) {
        var nextChar = if (lastChar == 'c') 'a' else lastChar + 1

        while (nextChar != ch) {
            ans++
            nextChar++

            if (nextChar == 'd') nextChar = 'a'
        }

        lastChar = ch
    }

    return ans + ('c' - lastChar)

}
