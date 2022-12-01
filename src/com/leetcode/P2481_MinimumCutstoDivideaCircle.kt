/**
 * easy.
 */
fun numberOfCuts(n: Int): Int {
    if (n == 1) return 0
    return if (n % 2 == 0) n / 2 else n
}
