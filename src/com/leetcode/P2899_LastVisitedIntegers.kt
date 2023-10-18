import java.util.*

/**
 * Stack
 */
fun lastVisitedIntegers(words: List<String>): List<Int> {
    val ans = mutableListOf<Int>()
    val stack = Stack<Int>()

    var i = 0
    while (i < words.size) {
        val word = words[i]

        if (word != "prev") {
            stack.push(word.toInt())
            i ++
        } else {
            val tmpStack = Stack<Int>().apply { addAll(stack) }

            while (i < words.size && words[i] == "prev") {
                ans += if (tmpStack.isEmpty()) -1 else tmpStack.pop()
                i++
            }
        }
    }

    return ans
}
