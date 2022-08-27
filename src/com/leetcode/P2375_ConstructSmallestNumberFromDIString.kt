import java.util.*

/**
 * dfs
 */
fun smallestNumber(pattern: String): String {
    var ans = ""
    val stack = Stack<Int>()
    val used = mutableSetOf<Int>()

    fun dfs(x: Int) {
        if (x == pattern.length) {
            ans = stack.toList().joinToString("")
            return
        }

        for (i in 1..9) {
            if (i in used) continue
            if (x < 0 || (pattern[x] == 'D' && i < stack.peek()) || (pattern[x] == 'I' && i > stack.peek())) {
                used += i
                stack.push(i)

                dfs(x + 1)

                stack.pop()
                used.remove(i)
            }

            if (ans.isNotEmpty()) return
        }
    }

    dfs(-1)

    return ans

}
