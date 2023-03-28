fun distMoney(money: Int, children: Int): Int {

    fun okay(c: Int): Boolean {
        val already = c * 8
        if (already + children - c > money) return false
        if (children - c == 1 && money - already == 4) return false
        if (children - c == 0 && money - already > 0) return false
        return true
    }

    for (i in children downTo 0) {
        if (okay(i)) return i
    }
    return -1
}
