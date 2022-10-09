import java.util.TreeMap

/**
 * TreeMap for merging non-overlapped intervals.
 */
class LUPrefix(n: Int) {

    val treeMap = TreeMap<Int, Int>()

    fun upload(video: Int) {

        var l = video
        var r = video

        val floor = treeMap.floorEntry(l)
        if (floor != null && floor.value + 1 == l) {
            l = floor.key
            treeMap.remove(floor.key)
        }

        val ceiling = treeMap.ceilingEntry(r)
        if (ceiling != null && ceiling.key - 1 == r) {
            r = ceiling.value
            treeMap.remove(ceiling.key)
        }

        treeMap[l] = r
    }

    fun longest(): Int {
        return treeMap[1] ?: 0
    }
}
