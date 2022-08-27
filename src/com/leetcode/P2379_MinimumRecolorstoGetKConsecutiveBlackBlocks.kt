/**
 * brute force solution
 */
fun minimumRecolors(blocks: String, k: Int): Int {


    return blocks.indices.map { i ->
        if (i + k >= blocks.length) Int.MAX_VALUE
        else (i until i + k).count { blocks[it] == 'W' }
    }.minOrNull()!!


}
