/**
 * Easy. Use set.
 */
fun repeatedCharacter(s: String): Char {

    val set = mutableSetOf<Char>()
    for (c in s) {
        if (c in set) return c
        set += c
    }
    return ' '
}
