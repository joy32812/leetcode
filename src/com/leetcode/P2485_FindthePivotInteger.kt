fun pivotInteger(n: Int): Int {

    for (i in  1 .. n) {
        val first = i * (i + 1) / 2
        val second = n * (n + 1) / 2 - first + i
        if (first == second) return i
    }

    return -1
}
