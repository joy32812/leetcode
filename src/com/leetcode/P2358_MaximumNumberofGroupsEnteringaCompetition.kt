/**
 * Greedy.
 */
fun maximumGroups(grades: IntArray): Int {
    grades.sort()

    return (1..grades.size).last { 1L * it * (it + 1) / 2 <= grades.size }
}
