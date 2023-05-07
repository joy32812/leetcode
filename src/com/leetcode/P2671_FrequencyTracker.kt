/**
 * Map
 */
class FrequencyTracker() {

    val N = 1_000_00 + 5
    val cnts = Array(N) { 0 }
    val freqs = mutableMapOf<Int, Int>()

    private fun addFreq(x: Int) {
        freqs[x] = freqs.getOrDefault(x, 0) + 1
    }

    private fun removeFreq(x: Int) {
        freqs[x] = freqs.getOrDefault(x, 0) - 1
        if (freqs[x] == 0) freqs.remove(x)
    }

    fun add(number: Int) {
        removeFreq(cnts[number])
        cnts[number]++
        addFreq(cnts[number])
    }

    fun deleteOne(number: Int) {
        if (cnts[number] == 0) return

        removeFreq(cnts[number])
        cnts[number]--
        addFreq(cnts[number])
    }

    fun hasFrequency(frequency: Int): Boolean {
        return frequency in freqs
    }
}
