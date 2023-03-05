fun coloredCells(n: Int): Long {
    if (n == 1) return 1L

    var last = 1L
    for (i in 2..n) {
        val tmp = last + 4 + 4 * (i - 2)
        last = tmp
    }

    return last
}
