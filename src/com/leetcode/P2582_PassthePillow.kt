fun passThePillow(n: Int, time: Int): Int {

    val len = n * 2 - 2
    val m = time % len

    var now = 0
    var diff = 1

    for (i in 1..m) {
        if (now == n - 1) {
            diff = -1
        }

        now += diff
    }

    return now + 1
}
