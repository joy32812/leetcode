fun evenOddBit(n: Int): IntArray {

    val chars = n.toString(2).reversed().toCharArray()

    var even = 0
    var odd = 0

    for (i in chars.indices) {
        if (chars[i] == '0') continue

        if (i % 2 == 0) {
            even += 1
        } else {
            odd += 1
        }

    }

    return intArrayOf(even, odd)
}
