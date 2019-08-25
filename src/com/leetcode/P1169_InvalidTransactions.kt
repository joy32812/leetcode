package com.leetcode

fun invalidTransactions(transactions: Array<String>): List<String> {

    fun biggerThan1000(s: String): Boolean {
        val (_, _, money, _) = s.split(",")
        return money.toInt() > 1000
    }

    fun tooSoon(i: Int): Boolean {
        for (j in 0 until transactions.size) {
            if (i == j) continue

            val (sname, stime, _, scity) = transactions[i].split(",")
            val (tname, ttime, _, tcity) = transactions[j].split(",")
            if (sname == tname && Math.abs(stime.toInt() - ttime.toInt()) <= 60 && scity != tcity) return true
        }

        return false
    }

    return transactions.withIndex().filter { biggerThan1000(it.value) || tooSoon(it.index) }.map { it.value }.toList()
}



fun main() {
    println(invalidTransactions(arrayOf("alice,20,800,mtv","alice,50,100,beijing")))
}