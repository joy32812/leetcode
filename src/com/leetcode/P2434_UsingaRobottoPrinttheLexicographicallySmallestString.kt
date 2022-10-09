import java.util.*

/**
 * Greedy.
 */
fun robotWithString(s: String): String {

    val treeMap = TreeMap<Char, Int>()
    s.forEach { c -> treeMap[c] = (treeMap[c] ?: 0) + 1 }

    val ans = StringBuilder()
    val t = LinkedList<Char>()
    for (c in s) {
        if (c == treeMap.firstKey()) {
            ans.append(c)
        } else {
            t += c
        }

        treeMap[c] = treeMap[c]!! - 1
        if (treeMap[c] == 0) treeMap.remove(c)

        while (t.isNotEmpty() && treeMap.isNotEmpty() && t.last() <= treeMap.firstKey()) {
            ans.append(t.removeLast())
        }
    }

    return ans.toString() + t.toList().reversed().joinToString("")
}
