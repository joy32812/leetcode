fun makeSmallestPalindrome(s: String): String {

    val chars = s.toCharArray()
    var l = 0
    var r = chars.size - 1

    while (l < r) {
        if (chars[l] != chars[r]) {
            val sc = minOf(chars[l], chars[r])
            chars[l] = sc
            chars[r] = sc
        }

        l++
        r--
    }

    return chars.joinToString("")
}
