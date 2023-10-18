/**
 * greedy algorithm.
 */
fun minProcessingTime(processorTime: List<Int>, tasks: List<Int>): Int {

    val sortedProcess = processorTime.sorted().flatMap { p -> listOf(p, p, p, p) }
    val sortedTasks = tasks.sortedDescending()

    return sortedProcess.zip(sortedTasks).maxOf { (p, t) -> p + t }
}
