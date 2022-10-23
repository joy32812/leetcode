/**
 * check segment intersection
 */
fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
    val (start1, end1) = event1
    val (start2, end2) = event2
    return !(start1 > end2 || start2 > end1)
}
