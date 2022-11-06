/**
 * brute force
 */
fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {

    fun changeOk(s: String, t: String) = s.toCharArray().zip(t.toCharArray()).count { it.first != it.second } <= 2
    fun okay(s: String) = dictionary.any { changeOk(s, it) }

    return queries.filter { okay(it) }
}
