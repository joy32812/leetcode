/**
 * brute force.
 */
fun isStrictlyPalindromic(n: Int): Boolean {

    fun String.isPalindrome() = this == reversed()
    return (2..n - 2).all { n.toString(it).isPalindrome() }

}

