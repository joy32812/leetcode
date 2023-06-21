/**
 * Mask + dfs + memo
 */
fun specialPerm(nums: IntArray): Int {
  val n = nums.size
  val mod = 1_000_000_000 + 7

  fun isSpecial(a: Int, b: Int) = 1L * a * b == 0L || a % b == 0 || b % a == 0

  val ansMap = mutableMapOf<String, Long>()

  fun dfs(prev: Int, mask: Int): Long {
    if (mask == 0) return 1L

    val key = "${prev}_${mask}"
    if (key in ansMap) return ansMap[key]!!

    var ans = 0L

    for (i in 0 until n) {
      if (mask and (1 shl i) == 0) continue
      if (!isSpecial(prev, nums[i])) continue

      val newMask = mask - (1 shl i)

      ans += dfs(nums[i], newMask)
      ans %= mod
    }

    ansMap[key] = ans
    return ans
  }

  return dfs(0, (1 shl n) - 1).toInt()
}