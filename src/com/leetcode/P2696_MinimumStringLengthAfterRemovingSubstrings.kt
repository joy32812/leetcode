import java.util.*

fun minLength(s: String): Int {

    val stack = Stack<Char>()


    for (c in s) {
        if (stack.isEmpty()) {
            stack.push(c)
        } else {
            if ((c == 'D' && stack.peek() == 'C') || (c == 'B' && stack.peek() == 'A')) {
                stack.pop()
            } else {
                stack.push(c)
            }
        }
    }

    return stack.size
}
