import java.util.*

data class RoomInUse(val endTime: Long, val room: Int)

/**
 * TreeMap + PriorityQueue
 */
fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    val cntMap = mutableMapOf<Int, Int>()
    meetings.sortBy { it[0] }

    val freeSet = TreeSet<Int>()
    (0 until n).forEach { freeSet += it }

    val pq = PriorityQueue<RoomInUse> { a, b ->
        if (a.endTime == b.endTime) a.room - b.room else a.endTime.compareTo(b.endTime)
    }

    var now = -1L
    for ((s, e) in meetings) {
        if (now < s) now = 0L + s

        while (pq.isNotEmpty() && pq.peek().endTime <= now) {
            val top = pq.poll()
            freeSet += top.room
        }

        if (freeSet.isEmpty()) {
            val top = pq.poll()
            now = top.endTime
            freeSet += top.room
        }

        // Use the first room.
        val room = freeSet.first()
        freeSet.remove(room)
        pq += RoomInUse(now + e - s, room)
        cntMap[room] = (cntMap[room] ?: 0) + 1
    }

    val max = cntMap.values.maxOrNull()!!
    return (0 until n).first { cntMap[it] == max }
}
