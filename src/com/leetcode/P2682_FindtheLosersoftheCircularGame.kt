fun circularGameLosers(n: Int, k: Int): IntArray {

    val win = IntArray(n) { 0 }

    win[0] = 1
    var d = 0
    var i = 1

    while (true) {
        d = (d + i * k) % n
        if (win[d] == 1) break
        win[d] = 1
        i ++
    }

    return win.withIndex().filter { it.value == 0 }.map { it.index + 1 }.toIntArray()
}

fun main() {
    println(circularGameLosers(6, 1).toList())
}
