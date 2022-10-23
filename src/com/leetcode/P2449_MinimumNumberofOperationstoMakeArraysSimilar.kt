/**
 * divide into evens and odds.
 * only compute the bigger case.
 */
fun makeSimilar(nums: IntArray, target: IntArray): Long {

    fun work(a: List<Int>, b: List<Int>) =
        a.indices.map { i -> if (a[i] > b[i]) 0L + a[i] - b[i] else 0L }.sum() / 2

    return work(nums.filter { it % 2 == 0 }.sorted(), target.filter { it % 2 == 0 }.sorted()) +
            work(nums.filter { it % 2 == 1 }.sorted(), target.filter { it % 2 == 1 }.sorted()
    )
}

