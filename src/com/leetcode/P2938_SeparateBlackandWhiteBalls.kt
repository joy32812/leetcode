fun minimumSteps(s: String): Long {

    val zeroCnt = s.count { it == '0' }

    val leftIndices = (0 until zeroCnt).filter { s[it] == '1' }
    val rightIndices = (zeroCnt until s.length).filter { s[it] == '0' }

    return leftIndices.zip(rightIndices).map { 0L + it.second - it.first }.sum()
}
