import java.util.TreeSet

/**
 * Two maps.
 */
class NumberContainers() {
    val num2Index = mutableMapOf<Int, TreeSet<Int>>()
    val index2num = mutableMapOf<Int, Int>()

    fun change(index: Int, number: Int) {

        if (index in index2num) {
            val old = index2num[index]!!
            num2Index[old]!!.remove(index)

            if (num2Index[old]!!.isEmpty()) {
                num2Index.remove(old)
            }
        }


        index2num[index] = number
        num2Index.getOrPut(number) { TreeSet() }.add(index)
    }

    fun find(number: Int): Int {
        return num2Index[number]?.first() ?: -1
    }

}
