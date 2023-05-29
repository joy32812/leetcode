fun buyChoco(prices: IntArray, money: Int): Int {

    val sum = prices.sorted().take(2).sum()

    return if (money < sum) money else money - sum

}
