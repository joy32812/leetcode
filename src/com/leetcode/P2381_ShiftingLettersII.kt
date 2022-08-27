import java.util.*


data class Shift(val p: Int,val isStart: Int, val delta: Int )
fun shiftingLetters(s: String, shifts: Array<IntArray>): String {

    val ss = mutableListOf<Shift>()
    for ((s, e, d) in shifts) {
        val delta = if (d == 0) -1 else 1
        ss.add(Shift(s, 0, delta))
        ss.add(Shift(e + 1, 1, delta))
    }

    ss.sortWith(compareBy({ it.p }, { it.isStart }))

    val treeMap = TreeMap<Int, Int>()
    treeMap[-1] = 0

    var now = 0
    for ((p, isStart, del) in ss) {

        if (isStart == 0) {
            now += del
        } else {
            now -= del
        }

        treeMap[p] = now
    }


    return s.mapIndexed { i, c ->
        val z = (treeMap.floorEntry(i).value % 26 + 26) % 26

        val t = c + z

        if (t > 'z') {
            'a' + (t - 'z') - 1
        } else {
            t
        }

    }.joinToString("")


}

fun main() {
    println(shiftingLetters("abc", arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(1, 2, 1),
        intArrayOf(0, 2, 1),
    )))
}
