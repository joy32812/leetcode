/**
 * easy sort.
 */
fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {

    val people = names.toList().zip(heights.toList())
    return people.sortedByDescending { it.second }.map { it.first }.toTypedArray()

}
