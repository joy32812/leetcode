fun validStrings(n: Int): List<String> {
    var ansSet = mutableSetOf("")

    for (i in 0 until n) {
        val tmpSet = mutableSetOf<String>()

        for (s in ansSet) {
            tmpSet += s + "1"
            if (s.isEmpty() || s.last() == '1') tmpSet += s + "0"
        }

        ansSet = tmpSet
    }

    return ansSet.toList()
}
