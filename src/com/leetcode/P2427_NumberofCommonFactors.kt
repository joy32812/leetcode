/**
 * brute force.
 */
fun commonFactors(a: Int, b: Int): Int {
    return (1..1000).count { a % it == 0 && b % it == 0 }
}
