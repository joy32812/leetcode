import java.util.*

/**
 * Stack
 */
fun removeStars(s: String): String {

    val stack = Stack<Char>()

    for (c in s) {
        if (c == '*') {
            if (stack.isEmpty()) continue
            stack.pop()
        } else {
            stack.push(c)
        }
    }

    return stack.joinToString("")
}
