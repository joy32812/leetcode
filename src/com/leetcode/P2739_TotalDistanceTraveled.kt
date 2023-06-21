/**
 * brute force
 */
fun distanceTraveled(mainTank: Int, additionalTank: Int): Int {

  var ans = 0
  var main = mainTank
  var additional = additionalTank

  while (main >= 5) {
    ans += 5 * 10
    main -= 5

    if (additional > 0) {
      additional --
      main ++
    }
  }

  return ans + main * 10
}